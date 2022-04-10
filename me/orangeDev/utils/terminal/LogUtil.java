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

package me.orangeDev.utils.terminal;

public class LogUtil {
    public static void infoLog(String message) {
        System.out.println(ColorUtil.ANSI_CYAN + "[Info] " + ColorUtil.ANSI_RESET + ColorUtil.ANSI_WHITE + message);
    }

    public static void warningLog(String message) {
        System.out.println(ColorUtil.ANSI_RED_BG + ColorUtil.ANSI_WHITE + "[WARN]" + ColorUtil.ANSI_RESET + " " + ColorUtil.ANSI_WHITE + message);
    }

    public static void errorLog(String message) {
        System.out.println(ColorUtil.ANSI_RED + "[Error] " + ColorUtil.ANSI_RESET + ColorUtil.ANSI_WHITE + message);
    }

    public static void otherLog(String colorutil, String title, String message) {
        System.out.println(colorutil + "[" + title +"] " + ColorUtil.ANSI_RESET + ColorUtil.ANSI_WHITE + message);
    }
}
