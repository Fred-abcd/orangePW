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

package me.orangeDev;

import me.orangeDev.utils.pw.Checker;
import me.orangeDev.utils.pw.Generator;
import me.orangeDev.utils.web.Downloader;
import me.orangeDev.utils.terminal.ClearTerminalUtil;
import me.orangeDev.utils.terminal.ColorUtil;
import me.orangeDev.utils.terminal.LogUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        ClearTerminalUtil.clear();
        drawLogo();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("");
        LogUtil.otherLog(ColorUtil.ANSI_GREEN, "Modes", "Check, Generate");
        input = scanner.nextLine();
        if (input.toLowerCase(Locale.ROOT).equals("check") || input.toLowerCase(Locale.ROOT).equals("generate")) {
            if (input.toLowerCase(Locale.ROOT).equals("check")) {
                ClearTerminalUtil.clear();
                Scanner scanner1 = new Scanner(System.in);
                String input1;
                LogUtil.otherLog(ColorUtil.ANSI_GREEN, "Modes", "Normal, PasswordList");
                input1 = scanner.nextLine();
                if ((input1.toLowerCase(Locale.ROOT).equals("normal") || input1.toLowerCase(Locale.ROOT).equals("passwordlist")) && input1 != null) {
                    if (input1.toLowerCase(Locale.ROOT).equals("passwordlist")) {
                        if (doesFileExist("facebook_phished.txt") && doesFileExist("fasttrack.txt") &&  doesFileExist("fern_wifi.txt") && doesFileExist("password-list-gov.txt") && doesFileExist("10-million-password-list-top-1000000.txt") && doesFileExist("10k-most-common.txt") && doesFileExist("rockyou-75.txt")) {
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");
                            File facebook_phished = new File("facebook_phished.txt");
                            File fasttrack = new File("fasttrack.txt");
                            File fern_wifi = new File("fern_wifi.txt");
                            File passwordListGov = new File("password-list-gov.txt");
                            File tenMillion = new File("10-million-password-list-top-1000000.txt");
                            File tenK = new File("10k-most-common.txt");
                            File rocku75 = new File("rockyou-75.txt");
                            LogUtil.infoLog("Password list loaded.");
                            try {
                                Checker.fileCheck(facebook_phished, args[0]);
                                Checker.fileCheck(fasttrack, args[0]);
                                Checker.fileCheck(fern_wifi, args[0]);
                                Checker.fileCheck(passwordListGov, args[0]);
                                Checker.fileCheck(tenMillion, args[0]);
                                Checker.fileCheck(tenK, args[0]);
                                Checker.fileCheck(rocku75, args[0]);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                LogUtil.errorLog("usage: java -jar orangePW.jar <password>");
                            }
                        } else {
                            LogUtil.errorLog("Password list not found.");
                            LogUtil.infoLog("Downloading password list...");
                            //lists
                            Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/facebook_phished.txt", "facebook_phished.txt");
                            Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/fasttrack.txt", "fasttrack.txt");
                            Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/fern_wifi.txt", "fern_wifi.txt");
                            Downloader.download("https://raw.githubusercontent.com/scipag/password-list/main/organizations/password-list-gov.txt", "password-list-gov.txt");
                            Downloader.download("https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-1000000.txt", "10-million-password-list-top-1000000.txt");
                            Downloader.download("https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10k-most-common.txt", "10k-most-common.txt");
                            Downloader.download("https://raw.githubusercontent.com/berandal666/Passwords/master/rockyou-75.txt", "rockyou-75.txt");

                            LogUtil.infoLog("Downloaded. Please run the program again.");

                        }
                    } else {
                        Checker.normalCheck(args[0]);
                        System.exit(0);
                    }
                } else {
                    LogUtil.errorLog("Invalid input.");
                }
            } else {
                ClearTerminalUtil.clear();
                Scanner scanner1 = new Scanner(System.in);
                String input1;
                LogUtil.otherLog(ColorUtil.ANSI_GREEN, "Length", "How long should the generated password be? (Best: 20)");
                input1 = scanner.nextLine();
                if (input1 != null) {
                    if (input1.matches("[0-9]+")) {
                        int length = Integer.parseInt(input1);
                        if (length > 0) {
                            CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/facebook_phished.txt", "facebook_phished.txt");
                            });
                            CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/fasttrack.txt", "fasttrack.txt");
                            });
                            CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/kkrypt0nn/Wordlists/master/famous/fern_wifi.txt", "fern_wifi.txt");
                            });
                            CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/scipag/password-list/main/organizations/password-list-gov.txt", "password-list-gov.txt");
                            });
                            CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-1000000.txt", "10-million-password-list-top-1000000.txt");
                            });
                            CompletableFuture<Void> future6 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10k-most-common.txt", "10k-most-common.txt");
                            });
                            CompletableFuture<Void> future7 = CompletableFuture.runAsync(() -> {
                                Downloader.download("https://raw.githubusercontent.com/berandal666/Passwords/master/rockyou-75.txt", "rockyou-75.txt");
                            });

                            CompletableFuture.allOf(future1, future2, future3, future4, future5, future6, future7).join();

                            ClearTerminalUtil.clear();
                            String generated = Generator.generatePassword(length);
                            LogUtil.otherLog(ColorUtil.ANSI_CYAN, "Generated Password", generated);
                            System.out.println("\n\n\n");
                            LogUtil.infoLog("Check if Password can be found in lists...");

                            List<File> files = Arrays.asList(
                                    new File("facebook_phished.txt"),
                                    new File("fasttrack.txt"),
                                    new File("fern_wifi.txt"),
                                    new File("password-list-gov.txt"),
                                    new File("10-million-password-list-top-1000000.txt"),
                                    new File("10k-most-common.txt"),
                                    new File("rockyou-75.txt")
                            );

                            files.parallelStream().forEach(file -> {
                                Checker.fileCheck(file, generated);
                            });

                        }
                    }
                }
            }
        } else {
            LogUtil.errorLog("Invalid input.");
        }
    }

    private static boolean doesFileExist(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    private static void drawLogo() {
        String text =" ██████╗ ██████╗  █████╗ ███╗   ██╗ ██████╗ ███████╗██████╗ ██╗    ██╗\n" +
                "██╔═══██╗██╔══██╗██╔══██╗████╗  ██║██╔════╝ ██╔════╝██╔══██╗██║    ██║\n" +
                "██║   ██║██████╔╝███████║██╔██╗ ██║██║  ███╗█████╗  ██████╔╝██║ █╗ ██║\n" +
                "██║   ██║██╔══██╗██╔══██║██║╚██╗██║██║   ██║██╔══╝  ██╔═══╝ ██║███╗██║\n" +
                "╚██████╔╝██║  ██║██║  ██║██║ ╚████║╚██████╔╝███████╗██║     ╚███╔███╔╝\n" +
                " ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝      ╚══╝╚══╝ \n" +
                "                                                                      ";
        int i;
        System.out.println(ColorUtil.ANSI_DARK_ORANGE);
        for(i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try{
                Thread.sleep(5);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}
