package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

public class Week3 {

    public static void main(String[] args) {

    }

    // Day 15
    /** Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST
     *  that the node's value equals the given value. Return the subtree rooted with that node.
     *  If such node doesn't exist, you should return NULL.*/
    public Week1.TreeNode searchBST(Week1.TreeNode root, int val) {
        return (root == null || root.val == val) ? root :
                ((root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val));
    }

    // Day 16

    /** Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

     IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

     Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

     IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

     However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

     Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

     Note: You may assume there is no extra space or special characters in the input string.*/
    public String validIPAddress(String IP) {
        String result = "Neither";

        if(IP == null || IP.length() == 0 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':')
            return result;

        /* validate for ipv4 */
        if(IP.contains(".")){

            String[] ipv4 = IP.split("[.]");

            if(ipv4.length > 4 || ipv4.length < 4 )
                return result;

            for(String ipv4Component : ipv4){

                /*checks if ipv4 contains numeric values only*/
                if(ipv4Component.matches("[0-9]+") == false || ipv4Component.length() > 4)
                    return result;

                /*checks for 0 - 255 range*/
                int ipv4ComponentNumeric = Integer.parseInt(ipv4Component);
                if(ipv4ComponentNumeric < 0 || ipv4ComponentNumeric > 255)
                    return result;

                /*checks for leading zero condition*/
                if(ipv4Component.length() > 1 && ipv4Component.charAt(0) == '0')
                    return result;
            }

            return "IPv4";

        } else if(IP.contains(":")){  /* validate for IPv6 */

            String[] ipv6 = IP.split(":");

            if(ipv6.length < 8 || ipv6.length > 8)
                return result;

            for(String ipv6Component : ipv6){
                /*checks for hexadecimal condition : a-f, A-F , 0-9*/
                if( ipv6Component.matches("[a-fA-F0-9]+") == false || ipv6Component.length() > 4)
                    return result;
            }
            return "IPv6";
        }
        return result;
    }





}
