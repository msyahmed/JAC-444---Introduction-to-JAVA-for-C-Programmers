/**********************************************

Workshop # 4 - Part 1 (1a,1b and 1c combined)

Course:<JAC 444> - Semester Winter 2018

Last Name:<Ahmed>

First Name:<Muhammad Shaher Yar>

ID:<126330166>

Section:<D>

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<March 28, 2018>

**********************************************/
package w4_1b;

import java.util.Arrays;
import java.util.List;

public class W4_1b {
    
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> topNames2017 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
            );
			
        topNames2017.stream().map(value -> {
        char firstchar = Character.toUpperCase(value.charAt(0));
        return firstchar + value.substring(1);
        }).sorted().forEach(System.out::println);
    }
}

