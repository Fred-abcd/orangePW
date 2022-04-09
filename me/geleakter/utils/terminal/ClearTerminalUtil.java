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

package me.geleakter.utils.terminal;


public class ClearTerminalUtil {
    public final static void newLineClear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public final static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            LogUtil.errorLog(e.getMessage());
        }
    }
}
