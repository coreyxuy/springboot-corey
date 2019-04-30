package com.itcorey.passw;

/**
 * Created by ：Corey
 * 11:32 2018/12/18
 * 多层循环破解密码
 */
public class TestString {
    public static void main(String[] args) {

        String password = randomString(4);
        System.out.println("密码是:" + password);

        char[] guessPassword = new char[4];
        outloop:
        for (short i = '0'; i <= 'z'; i++) {
            for (short j = '0'; j <= 'z'; j++) {
                for (short k = '0'; k <= 'z'; k++) {
                    for (short l = '0'; l <= 'z'; l++) {
                        if (!isLetterOrDigit(i, j, k,l))
                            continue;
                        guessPassword[0] = (char) i;
                        guessPassword[1] = (char) j;
                        guessPassword[2] = (char) k;
                        guessPassword[3] = (char) l;
                        String guess = new String(guessPassword);
//                  System.out.println("穷举出来的密码是：" + guess);

                        if (guess.equals(password)) {
                            System.out.println("找到了，密码是" + guess);
                            break outloop;
                        }

                    }
                }
            }
        }
    }
    private static boolean isLetterOrDigit(short i, short j, short k,short l) {
        return Character.isLetterOrDigit(i) &&
                Character.isLetterOrDigit(j) &&
                Character.isLetterOrDigit(k) &&
                Character.isLetterOrDigit(l);
    }

    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        for (short l = 'A'; l <= 'Z'; l++) {
            pool += (char) l;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }


}
