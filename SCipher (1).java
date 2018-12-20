/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scipher;

import java.util.Scanner;

/**
 *
 * @author CSE039
 */
public class SCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input, preprocess,encrypt,decrypt;
        int k,kd;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        System.out.println("Enter K: ");
        k = sc.nextInt();
        System.out.println("Input Text - " + input);
        preprocess = pre_process(input);
        System.out.println("Pre Processed - " + preprocess);
        encrypt = encode(preprocess , k);
        System.out.println("Cipher - " + encrypt);
        System.out.println("Enter K: ( For Decryption ) ");
        kd = sc.nextInt();
        decrypt = decode(encrypt , kd);
        System.out.println("Plait Text - " + decrypt);
        //#################################BRUTEFORCE
        System.out.println("\n\n\n");
        System.out.println("Brute Force Attack:");
        for(int j = 0;j < 26; j++){
             decrypt = decode(encrypt , j);
            System.out.println( j+1 + " : Plait Text - " + decrypt);
        }
        
        
    }

    private static String pre_process(String input) {
        char[] pre = input. toCharArray();
        for (int i=0; i<pre.length;i++){
            if(Character.isUpperCase(pre[i])) {
                //System.out.println(pre[i]);
               pre[i] = Character.toLowerCase(pre[i]);
            } else {
                
            }
        }
        
        String processed = new String(pre);
        return processed;
        
    }

    private static String encode(String preprocess, int k) {
     char[] pre = preprocess. toCharArray();
     
     
     for (int i=0; i<pre.length;i++){
            if(Character.isAlphabetic(pre[i])) {
                //System.out.println(pre[i]);
                int p = pre[i];
               int enc = (p + k) % 122;
               if(enc<97){
                   enc += 97;
               }
               pre[i] = (char)enc;
                //System.out.println(pre[i]);
            } else {
                
            }
        }
        
        String encrypt = new String(pre);
  
    return encrypt;
    }

    private static String decode(String encrypt, int k) {
        char[] pre = encrypt. toCharArray();
     
     
     for (int i=0; i<pre.length;i++){
            if(Character.isAlphabetic(pre[i])) {
                //System.out.println(pre[i]);
                int p = pre[i];
               int enc = (p - k) % 122 ;
              if(enc<97){
              enc += 25;
              }
                //System.out.println(enc);
               pre[i] = (char)enc;
            } else {
                
            }
        }
        
        String decrypt = new String(pre);
  
    return decrypt;
    }

    }



/*
#############################################
run:
Meet me At The paRty!!!
Enter K: 
3
Input Text - Meet me At The paRty!!!
Pre Processed - meet me at the party!!!
Cipher - phhw ph dw wkh sduwc!!!
Enter K: ( For Decryption ) 
3
Plait Text - meet me at the party!!!




Brute Force Attack:
1 : Plait Text - phhw ph dw wkh sduwc!!!
2 : Plait Text - oggv og cv vjg rctvb!!!
3 : Plait Text - nffu nf bu uif qbsua!!!
4 : Plait Text - meet me at the party!!!
5 : Plait Text - ldds ld ys sgd oyqsx!!!
6 : Plait Text - kccr kc xr rfc nxprw!!!
7 : Plait Text - jbbq jb wq qeb mwoqv!!!
8 : Plait Text - iaap ia vp pda lvnpu!!!
9 : Plait Text - hyyo hy uo ocy kumot!!!
10 : Plait Text - gxxn gx tn nbx jtlns!!!
11 : Plait Text - fwwm fw sm maw iskmr!!!
12 : Plait Text - evvl ev rl lyv hrjlq!!!
13 : Plait Text - duuk du qk kxu gqikp!!!
14 : Plait Text - cttj ct pj jwt fphjo!!!
15 : Plait Text - bssi bs oi ivs eogin!!!
16 : Plait Text - arrh ar nh hur dnfhm!!!
17 : Plait Text - yqqg yq mg gtq cmegl!!!
18 : Plait Text - xppf xp lf fsp bldfk!!!
19 : Plait Text - wooe wo ke ero akcej!!!
20 : Plait Text - vnnd vn jd dqn yjbdi!!!
21 : Plait Text - ummc um ic cpm xiach!!!
22 : Plait Text - tllb tl hb bol whybg!!!
23 : Plait Text - skka sk ga ank vgxaf!!!
24 : Plait Text - rjjy rj fy ymj ufwye!!!
25 : Plait Text - qiix qi ex xli tevxd!!!
26 : Plait Text - phhw ph dw wkh sduwc!!!
BUILD SUCCESSFUL (total time: 19 seconds)
*/