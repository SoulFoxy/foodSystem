
import static java.awt.PageAttributes.MediaType.A;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sing1
 */
public class code_02 {
public static String A = "0";
public static String birth = "";
    /**
     * @param args the command line arguments
     */
public static final int special = (int) (Math.random() * 4);
public static final String[][] meal_list = {{"M001", "蜂蜜奶油鬆餅", "140"}, {"M002", "抹茶紅豆鬆餅", "190"},
    {"M003", "栗子蒙布朗鬆餅", "200"}, {"M004", "檸檬冰淇淋鬆餅", "200"}};
public static final String[][] drink_list = {{"D001", "伯爵紅茶", "70"}, {"D002", "榛果奶茶", "90"},
    {"D003", "玫瑰拿鐵", "100"}, {"D004", "太妃糖牛奶", "110"}};

    public static void main(String[] args)throws FileNotFoundException, IOException {
    
        // TODO code application logic here
        String[] category = {"M|鬆餅", "D|飲料"};
        String[] manu = {"編號", "品項名", "價格"};
        String[][] items = {{"M001", "蜂蜜奶油鬆餅", "140"},
            {"M002", "抹茶紅豆鬆餅", "190"},
            {"M003", "栗子蒙布朗鬆餅", "200"},
            {"M004", "檸檬冰淇淋鬆餅", "200"},
            {"D001", "伯爵紅茶", "70"},
            {"D002", "榛果奶茶", "90"},
            {"D003", "玫瑰拿鐵", "100"},
            {"D004", "太妃糖牛奶", "110"}};
        
        double[] price = new double[items.length];
        for(int i = 0; i < items.length; i++){
            price[i] = Double.parseDouble(items[i][2]);
        }
        
        for (String manu1 : manu) {
            System.out.print(manu1 + "\t");
        }
System.out.println();
        for (String[] item1 : items) {
            for (String item : item1) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

System.out.println("─────────");
boolean isContinue = false;
String idx_list = "";
Scanner sc = new Scanner(System.in);
double total = 0;
do {
            for (int i = 0; i < category.length; i++) {
                System.out.println("[" + (i + 1) + "]" + category[i].split("\\|")[1]);
            }
            System.out.println("今日推薦：");
        for (int i = special; i < 4; i++) {
            System.out.println(Arrays.toString(meal_list[i]));
        }
        for (int i = special; i < 4; i++) {
            System.out.println(Arrays.toString(drink_list[i]));
        }

            System.out.println("請選擇想要呈現的菜單分類(輸入阿拉伯數字代號");
            int index = sc.nextInt();
            sc.nextLine();
            String cate = category[index - 1].split("\\|")[1];
            String cate_id = "NA";
            for (String category1 : category) {
                String[] cate_info = category1.split("\\|");
                if (cate.equals(cate_info[1])) {
                    cate_id = cate_info[0];
                    break;
                }
            }
            if (!cate_id.equals("NA")) {
                for (int i = 0; i < items.length; i++) {
                    if (items[i][0].startsWith(cate_id)) {
                        String[] item = items[i];
                        for (String f : item) {
                            System.out.print(f + "\t");
                        }
                    }
                }
            }else {
                System.out.println("無此分類");
            }
            System.out.println();
            System.out.println("請輸入品項編號");
            
           


// String buy_id = "M002";
String buy_id = sc.nextLine();
List buy_list;
            buy_list = new ArrayList();
for(int i=0; i < items.length; i++){
    if(buy_id.toUpperCase().equals(items[i][0].toUpperCase())){
        System.out.println("是否要點餐(Y/N)");
        String buyCheck = sc.nextLine();
        if(buyCheck.toUpperCase().startsWith("Y")){
                total = total + price[i];
                idx_list = idx_list + String.valueOf(i) + "|";
        }
        System.out.println("請問是否繼續瀏覽菜單(Y/N)");
        buyCheck = sc.nextLine();
        if(buyCheck.toUpperCase().startsWith("Y")) {
            isContinue = true;
        }else{
            isContinue = false;
        }
        break;
    }
}
}while (isContinue);

System.out.println("請輸入會員代碼，若無請輸入N");
            A = sc.nextLine();
            if (A.toUpperCase().equals("N")) {
                System.out.println("請問是否要申辦會員？(Y/N)");
                A = sc.nextLine();
                if (A.toUpperCase().equals("Y")) {
                    System.out.println("請輸入您的出生年月日八碼（西元年／月／日）。");
                    Scanner imformation = new Scanner(System.in);
                    birth = imformation.nextLine();
                    //getAdd(bm | bd);//傳回值
                    //產生會員代碼
                    System.out.println("您的會員代碼是：" + (int)(Math.random()*100));
                } else {
                    System.out.print("\n");
                }
            } else {
                String Number = A; //會員代碼
            }

System.out.println("==========餐點清單如下===========");

if (!idx_list.equals("")) {
            String[] item_idx = idx_list.split("\\|");
            for (int i = 0; i < item_idx.length; i++) {
                int idx = Integer.parseInt(item_idx[i]);
                String[] item = items[idx];
                for (String f : item) {
                    System.out.print(f + "\t");
                }
                System.out.println();
            }
    
}
System.out.println("餐點總價格為" + total + "元");

    


    }
    
    
    
    public static int getAdd(String birth) {
        if (birth.length() == 8) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
        String year = birth.substring(0, 4);
        int by = Integer.parseInt(year);
        int bm = Integer.parseInt(birth.substring(4, 6));
        int bd = Integer.parseInt(birth.substring(6, 8));
        if (by < 1000) {
            int newyear = by + 1911;
            System.out.println(newyear);
        }
        boolean isContinue = false;
        if (!isContinue) {
            if (bm == 1 || bm == 3 || bm == 5 || bm == 7 || bm == 8 || bm == 10 || bm == 12) {
                if (bd > 31) {
                    isContinue = false;
                }
            } else if (bm == 4 || bm == 6 || bm == 9 || bm == 11) {
                isContinue = false;
            } else if (bm == 2) {
                if (isContinue && bd > 29) {
                    isContinue = false;
                }
                if (!isContinue && bd > 28) {
                    isContinue = false;
                }
            } else {
                isContinue = false;
            }
        }

        System.out.println(bm | bd);
        return bm | bd;
                   
    }
    
}
