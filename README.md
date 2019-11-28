Java Regex
Java
Java Regex (Biểu thức chính quy)
Java Regex hoặc Regular Expression là một giao diện lập trình để xác định các mô hình dùng để tìm kiếm hoặc thao tác chuỗi. Nó được sử dụng rộng rãi để định nghĩa các khuôn mẫu cho chuỗi ví dụ như mật khẩu, email, url,.... Hoặc được dùng để thay thế (replace) các chuỗi ký tự theo mẫu.

Giao diện lập trình Java Regex cung cấp 1 interface và 3 lớp trong gói java.util.regex.

Gói java.util.regex

Gói này cung cấp các lớp và interface như bên dưới cho các biểu thức chính quy. Các lớp Matcher và Pattern được sử dụng rộng rãi trong các biểu thức chính quy của java.

Interface MatchResult
Lớp Matcher
Lớp Pattern
Lớp PatternSyntaxException
Lớp Matcher

Lớp Matcher thực thi interface MatchResult. Nó được sử dụng để thực hiện các hoạt động so khớp trên một chuỗi ký tự.

Lớp Pattern

Đây là phiên bản biên dịch của một biểu thức chính quy. Nó được sử dụng để xác định một khuôn mẫu cho các biểu thức chính quy.

PatternSyntaxException

PatternSyntaxException sẽ xảy ra khi mà có lỗi cú pháp trong mẫu Regular Expression.

Quy tắc viết biểu thức chính quy

STT	Biểu thức chính quy	Mô tả
1	.	Khớp (match) với bất kỳ ký tự nào
2	^regex	Biểu thức chính quy phải  khớp tại điểm bắt đầu
3	regex$	Biểu thức chính quy phải khớp ở cuối dòng.
4	[abc]	Thiết lập định nghĩa, có thể khớp với a hoặc b hoặc c.
5	[abc][vz]	Thiết lập định nghĩa, có thể khớp với a hoặc b hoặc c theo sau là v hay z.
6	[^abc]	Khi dấu ^ xuất hiện như là nhân vật đầu tiên trong dấu ngoặc vuông, nó phủ nhận mô hình. Điều này có thể khớp với bất kỳ ký tự nào ngoại trừ a hoặc b hoặc c.
7	[a-d1-7]	Phạm vi: phù hợp với một chuỗi giữa a và điểm d và con số từ 1 đến 7.
8	X|Z	Tìm X hoặc Z.
9	XZ	Tìm X và theo sau là Z.
10	$	Kiểm tra kết thúc dòng.

11	\d	Số bất kỳ, viết ngắn gọn cho [0-9]
12	\D	Ký tự không phải là số, viết ngắn gon cho [^0-9]
13	\s	Ký tự khoảng trắng, viết ngắn gọn cho [ \t\n\x0b\r\f]
14	\S	Ký tự không phải khoản trắng, viết ngắn gọn cho [^\s]
15	\w	Ký tự chữ, viết ngắn gọn cho [a-zA-Z_0-9]
16	\W	Ký tự không phải chữ, viết ngắn gọn cho [^\w]
17	\S+	Một số ký tự không phải khoảng trắng (Một hoặc nhiều)
18	\b	Ký tự thuộc a-z hoặc A-Z hoặc 0-9 hoặc _, viết ngắn gọn cho [a-zA-Z0-9_].

19	*	Xuất hiện 0 hoặc nhiều lần, viết ngắn gọn cho {0,}
20	+	Xuất hiện 1 hoặc nhiều lần, viết ngắn gọn cho {1,}
21	?	Xuất hiện 0 hoặc 1 lần, ? viết ngắn gọn cho {0,1}.
22	{X}	Xuất hiện X lần, {}
23	{X,Y}	Xuất hiện trong khoảng X tới Y lần.
24	*?	* có nghĩa là xuất hiện 0 hoặc nhiều lần, thêm ? phía sau nghĩa là tìm kiếm khớp nhỏ nhất.
Một số ký tự đặc biệt trong Java Regex

\.[{(*+?^$|

Những ký tự liệt kê ở trên là các ký tự đặc biệt. Trong Java Regex bạn muốn nó hiểu các ký tự đó theo cách thông thường bạn cần thêm dấu \ ở phía trước.

Chẳng hạn ký tự chấm . java regex đang hiểu là một ký tự bất kỳ, nếu bạn muốn nó hiểu là một ký tự chấm thông thường, cần phải có dấu \ phía trước.

// Mẫu regex mô tả một ký tự bất kỳ.
String regex = ".";

// Mẫu regex mô tả  ký tự dấu chấm.
String regex = "\\.";
Một số ví dụ về sử dụng Java Regex
VD1: Có 3 cách để viết regex trong java như sau

import java.util.regex.*;
public class RegexExample1{
public static void main(String args[]){
    //Cách 1
    Pattern p = Pattern.compile(".s");//Dấu . đại diện cho một ký tự bất kỳ
    Matcher m = p.matcher("as");
    boolean b = m.matches();

    //Cách 2
    boolean b2=Pattern.compile(".s").matcher("as").matches();

    //Cách 3
    boolean b3 = Pattern.matches(".s", "as");

    System.out.println(b+" "+b2+" "+b3);
}}
Output: true true true

VD2: Dấu . đại diện cho một ký tự bất kỳ

import java.util.regex.*;
class RegexExample2{
public static void main(String args[]){
    System.out.println(Pattern.matches(".s", "as"));//true ký tự thứ 2 là chữ s
    System.out.println(Pattern.matches(".s", "mk"));//false ký tự thứ 2 không phải chữ s
    System.out.println(Pattern.matches(".s", "mst"));//false có thêm chữ t sau chữ s
    System.out.println(Pattern.matches(".s", "amms"));//false có nhiều hơn 1 ký tự trước chữ s
    System.out.println(Pattern.matches("..s", "mas"));//true 2ký tự bất kỳ theo sau bởi chữ s
}}
VD3: phân lớp ký tự

import java.util.regex.*;
class RegexExample3{
public static void main(String args[]){
    System.out.println(Pattern.matches("[amn]", "abcd"));//false chỉ chấp nhận 1 ký tự a hoặc m hoặc n
    System.out.println(Pattern.matches("[amn]", "a"));//true chỉ chấp nhận 1 ký tự a hoặc m hoặc n
    System.out.println(Pattern.matches("[amn]", "ammmna"));//false nhiều hơn 1 ký tự hoặc a hoặc m hoặc n
}}
VD4: số lượng ký tự

import java.util.regex.*;
class RegexExample4{
public static void main(String args[]){
    System.out.println("Ký tự ? ....");
    System.out.println(Pattern.matches("[amn]?", "a"));//true (a hoặc m hoặc n xuất hiện 1 lần)
    System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a xuất hiện nhiều lần)
    System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a hoặc m hoặc n xuất hiện nhiều lần)
    System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a xuất hiện nhiều lần)
    System.out.println(Pattern.matches("[amn]?", "am"));//false

    System.out.println("Ký tự + ....");
    System.out.println(Pattern.matches("[amn]+", "a"));//true (a hoặc m hoặc n xuất hiện 1 hoặc nhiều lần)
    System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a xuất hiện nhiều lần)
    System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a hoặc m hoặc n xuất hiện nhiều lần)
    System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z và t không đúng với regex)

    System.out.println("Ký tự * ....");
    System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a hoặc m hoặc n) có thể không xuất hiện hoặc xuất hiện nhiều lần

}}
VD5:metacharacters

import java.util.regex.*;
class RegexExample5{
public static void main(String args[]){
    System.out.println("metacharacters d....");//\\d nghĩa là chấp nhận số

    System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)
    System.out.println(Pattern.matches("\\d", "1"));//true (1 số)
    System.out.println(Pattern.matches("\\d", "4443"));//false (nhiều số)
    System.out.println(Pattern.matches("\\d", "323abc"));//false (số và ký tự)

    System.out.println("metacharacters D....");//\\D nghĩa là chấp nhận các ký tự không phải số

    System.out.println(Pattern.matches("\\D", "abc"));//false (nhiều ký tự không phải số)
    System.out.println(Pattern.matches("\\D", "1"));//false (số)
    System.out.println(Pattern.matches("\\D", "4443"));//false (nhiều số)
    System.out.println(Pattern.matches("\\D", "323abc"));//false (số và ký tự)
    System.out.println(Pattern.matches("\\D", "m"));//true (không phải số và xuất hiện 1 lần)

    System.out.println("metacharacters D with quantifier....");
    System.out.println(Pattern.matches("\\D*", "mak"));//true (không phải số và xuất hiện 0 hoặc nhiều lần)

}}
VD6: cắt chuỗi

public class SplitWithRegex {

   public static final String TEXT = "This is my text";

   public static void main(String[] args) {
       System.out.println("TEXT=" + TEXT);
       // Khoảng trắng xuất hiện 1 hoặc nhiều lần.
       // Các ký tự khoảng trắng: \t\n\x0b\r\f
       // Kết hợp quy tắc: \s và +
       String regex = "\\s+";
       String[] splitString = TEXT.split(regex);
       // 4
       System.out.println(splitString.length);

       for (String string : splitString) {
           System.out.println(string);
       }

       // Thay thế tất cả các khoảng trắng với ký tự tab.
       String newText = TEXT.replaceAll("\\s+", "\t");
       System.out.println("New text=" + newText);
   }
}
VD7: replace

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    private static String REGEX = "HaNoi";
    private static String INPUT = "HaNoi 123456. HaNoi 654321.";
    private static String REPLACE = "TPHCM";

    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(INPUT);
       INPUT = m.replaceAll(REPLACE);
       System.out.println(INPUT);
   }
}
Result:TPHCM 123456. TPHCM 654321.

Cảm ơn các bạn đã đọc đến dòng này 😄!!!
