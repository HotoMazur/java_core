package org.example.tasks.md5;

public class MD5String {
    private static final int INIT_A = 0x67452301;
    private static final int INIT_B = (int) 0xEFCDAB89L;
    private static final int INIT_C = (int) 0x98BADCFEL;
    private static final int INIT_D = 0x10325476;

    private static final int[] SHIFT_F = {
            7, 12, 17, 22
    };
    private static final int[] SHIFT_G = {
            5, 9, 14, 20
    };
    private static final int[] SHIFT_H = {
            4, 11, 16, 23
    };
    private static final int[] SHIFT_I = {
            6, 10, 15, 21
    };

    private static final int[] K = new int[64];

    static {
        for (int i = 0; i < 64; i++) {
            K[i] = (int) Math.abs(Math.sin(i + 1)) * (int) Math.pow(2, 32);
        }
    }

    public static String encode(String input) {
        byte[] pad = paddingString(input);

        int a = INIT_A, b = INIT_B, c = INIT_C, d = INIT_D;
        int[] M = new int[16];
        for (int i = 0; i < 16; i++) {
            long value = pad[i * 4] & 0xFF;
            value |= (pad[i * 4 + 1] << 8) & 0xFFFF;
            value |= (pad[i * 4 + 2] << 16) & 0xFFFFFF;
            value |= (pad[i * 4 + 3] << 24) & 0xFFFFFFFF;
            M[i] = (int) value;
        }

        int aa = a, bb = b, cc = c, dd = d;


        int count = 0;
        for (int i = 0; i < 16; i++) {
            a = round(a, b, c, d, M[i], SHIFT_F[count], K[i], 0);
            d = c; c = b; b = a; a = aa;
            aa = a;
            count++;
            if (count == 4) {
                count = 0;
            }
        }


        for (int i = 0; i < 16; i++) {
            a = round(a, b, c, d, M[(5 * i + 1) % 16], SHIFT_G[count], K[i + 16], 1);
            d = c; c = b; b = a; a = aa;
            aa = a;
            count++;
            if (count == 4) {
                count = 0;
            }
        }

        for (int i = 0; i < 16; i++) {
            a = round(a, b, c, d, M[(3 * i + 5) % 16], SHIFT_H[count], K[i + 32], 2);
            d = c; c = b; b = a; a = aa;
            aa = a;
            count++;
            if (count == 4) {
                count = 0;
            }
        }

        for (int i = 0; i < 16; i++) {
            a = round(a, b, c, d, M[(7 * i) % 16], SHIFT_I[count], K[i + 48], 3);
            d = c; c = b; b = a; a = aa;
            aa = a;
            count++;
            if (count == 4) {
                count = 0;
            }
        }

        a += aa; b += bb; c += cc; d += dd;


        return String.format("%08x%08x%08x%08x",
                Integer.reverseBytes(a),
                Integer.reverseBytes(b),
                Integer.reverseBytes(c),
                Integer.reverseBytes(d));
    }

    public static int round(int a, int b, int c, int d, int m, int s, int k, int t) {
        int f = switch (t) {
            case 0 -> (b & c) | (~b & d);
            case 1 -> (b & d) | (c & ~d);
            case 2 -> b ^ c ^ d;
            case 3 -> c ^ (b | ~d);
            default -> 0;
        };
        return b + Integer.rotateLeft(a + f + m + k, s);
    }


    private static byte[] paddingString(String input) {
        byte[] inputBytes = input.getBytes();
        long len = inputBytes.length * 8;

        int padding = (64 - ((inputBytes.length + 8) % 64));
        //if (padding == 0) padding = 64;
        byte[] pad = new byte[inputBytes.length + padding + 8];
        System.arraycopy(inputBytes, 0, pad, 0, inputBytes.length);
        pad[inputBytes.length] = (byte) 0x80;

        for (int i = 0; i < 8; i++) {
            pad[pad.length - 8 + i] = (byte) (len >>> (i * 8));
        }
        return pad;
    }


    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(String.format("%02X", b[i] & 0xFF));
        }
        return sb.toString();
    }
}
