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

package me.geleakter.utils.pw;

import me.geleakter.utils.terminal.LogUtil;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Checker {
    //print every line in the file
    public static void print(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void normalCheck(String word) {
        //check if a password is secure
        if (word.length() < 8) {
            LogUtil.warningLog("Password is too short.");
            //System.out.println("Password is too short.");
        } else if (!word.matches(".*[a-zA-Z]+.*")) {
            LogUtil.warningLog("Password does not contain a letter.");
            //System.out.println("Password does not contain a letter.");
        } else if (!word.matches(".*[0-9]+.*")) {
            LogUtil.warningLog("Password does not contain a number.");
            //System.out.println("Password does not contain a number.");
        } else {
            LogUtil.infoLog("Password is secure.");
            //System.out.println("Password is secure.");
        }
    }

    public static void fileCheck(File file, String word) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals(word)) {
                    LogUtil.warningLog("!!! PASSWORD FOUND IN " + file.getName() + " !!! -> NOT SAFE");
                    //System.out.println("!!! FOUND !!! -> NOT SAFE");
                    return;
                }
            }
            LogUtil.infoLog("Password not found in list: " + file.getName() + "!");
            //System.out.println("not found -> safe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
