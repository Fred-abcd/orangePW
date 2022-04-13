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
    private static final char[] all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!§$%&/()=?{[]}+*~#'-_.:,;@€".toCharArray();
    private static final char[] lower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] number = "1234567890".toCharArray();
    private static final char[] symbol = "!§$%&/()=?{[]}+*~#'-_.:,;@€".toCharArray();

    public static String generatePassword(int length, boolean lowercase, boolean uppercase, boolean numbers, boolean symbols) {
        String password = "";
        Random random = new SecureRandom();
        if (lowercase) {
            password += lower[random.nextInt(lower.length)];
        }
        if (uppercase) {
            password += upper[random.nextInt(upper.length)];
        }
        if (numbers) {
            password += number[random.nextInt(number.length)];
        }
        if (symbols) {
            password += symbol[random.nextInt(symbol.length)];
        }
        for (int i = 0; i < length - (lowercase ? 1 : 0) - (uppercase ? 1 : 0) - (numbers ? 1 : 0) - (symbols ? 1 : 0); i++) {
            password += all[random.nextInt(all.length)];
        }
        return password;
    }

    public static String generatePassword(int length) {
        return generatePassword(length, true, true, true, true);
    }
}
