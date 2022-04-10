/*
 * Since: April 2022
 * Author: orangeDev
 * Description:
 *
 * Copyright 2022 orangeDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.orangeDev.utils.pw;

import java.security.SecureRandom;
import java.util.Random;

public class Generator {
    //generating a safe password
    /*
    public static String generatePassword(int length) {
        String password = "";
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!$%&/()=?-.,;._#+*~}@";
        for (int i = 0; i < length; i++) {
            password += chars.charAt((int) (Math.random() * chars.length()));
        }
        return password;
    }*/

    private static final char[] all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!§$%&/()=?{[]}+*~#'-_.:,;@€".toCharArray();
    private static final char[] lower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] numbers = "1234567890".toCharArray();
    private static final char[] symbols = "!§$%&/()=?{[]}+*~#'-_.:,;@€".toCharArray();

    public static String generatePW(int length) {
        Random random = new SecureRandom();

        StringBuilder pw = new StringBuilder();

        for (int i = 0; i < length-4; i++) {
            pw.append(all[random.nextInt(all.length)]);
        }

        pw.insert(random.nextInt(pw.length()), lower[random.nextInt(lower.length)]);
        pw.insert(random.nextInt(pw.length()), upper[random.nextInt(upper.length)]);
        pw.insert(random.nextInt(pw.length()), numbers[random.nextInt(numbers.length)]);
        pw.insert(random.nextInt(pw.length()), symbols[random.nextInt(symbols.length)]);

        return pw.toString();
    }
}
