package Chapter3;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;

public class C3All {
    static final private String FileDir = "D:\\Project\\Java\\java_study\\src\\Chapter3\\";
    //与C++不同的是，main需要有一个包装类来进行调用
    //即public 且 static属性的main方法
    //注意：class文件名需要与类名（主调用的）一致
    public static void main(String[] args) {
        //测试StringBuilder
        //ExTestStringBuilder();

        //测试Null与空白字符串String对象
        //ExNullBlank();

        //测试输入Scanner
        //ExScanner1();

        //测试输入Console
        //ExConsole();

        //格式化输入
        //ExFormatOutput();

        //文件输入与输出
        //ExFileIO();

        //控制流程
        //ExControlPath();

        //大数值
        //ExBigNum();

        //数组
        //ExNumGroup();

        //命令行参数
        //ExCMDParam();

        //数组排序
        //ExNumGroupSort();
    }

    private static void Print(String s){
        System.out.println("-----------");
        System.out.println(s);
    }

    public static void ExSomeThing(){
        //Java同C++一样是一个强类型语言
        //与C++不同，数据类型的大小与编译器无关，解决了移植问题
        //  int 4字节
        //  short 2字节
        //  long 8字节
        //  byte 1字节
        //长整型数值有一个后缀L或l 如400000L
        //十六进制有前缀0x或0X
        //八进制有前缀 0
        //现在二进制的表示可以加前缀0b或0B
        //可以为数字字面量加下划线1_000_000（0B1111_0100_0010_0100_0000）两者都表示一百万
        //注意：Java没有unsigned形式

        //浮点类型
        //  float 4字节
        //  double 8字节
        //  float类型的数值有一个后缀F或f 3.14F没有的话默认使用double类型
        //  也可显式地用D或d表示一个double类型的数值
        //  可以使用十六进制表示一个浮点数值0.125 = 2-3可以表示成0x1.0p-3
        //三个的特殊的浮点数值
        //  一个正整数除以0的结果是正无穷大 Double.POSITIVE_INFINITY
        //  0/0或负数的平方根结果是NaN Double.NaN
        //  还有一个负无穷大 Double.NEGATIVE_INFINITY
        //注意：不能通过（x==Double.NaN）来检测 【结果永远是False】
        //  因为所有的“非数值”的值都认为是不相同的，但可以使用Double.isNaN方法
        //  if(Double.isNaN(x))
        //注意：浮点数值不适用于无法接受舍入误差的金融计算中。应当使用BigDecimal类

        //char类型
        //原本用于表示单个字符，如今有些Unicode字条可以用一个char值进行描述，另外一些则需要两个
        //char类型字面量要用单引号括起来，'A'。
        //char类型可以表示为十六进制值，范围从\u0000到\uffff
        //转义字条甚至可以出现在加引号的字符常量或字符串之外
        //  例如：public static void main(String\u0058\u005D args)
        //注意Unicode转义序列会在解析代码之前得到处理（也就是说执行前就得到了翻译，如上面的例子）

        //boolean类型
        //false和true
        //  注意：与C++不同的是数值不能代替boolean值，比如0与非0值

        //变量名可以使用表示字母的Unicode字符
        //  如果想要知道是否属于Java中的字母可以使用Character类的isJavaIdentifierStart
        //  和isJavaIdentifierPart方法来检查

        //不能使用未初始化的变量
        //注意：在C++中是区别声明与定义的
        //ini i =10;//是一个定义
        //extern int i；//是一个声明
        //而Java中不区分变量的声明与定义

        //常量
        //在Java中，利用关键字final指示常量。例如：
        //final double CM_PER_INCH = 2.54
        //类型常量则再加static
        //  需要注意：类常量的定义位于main方法的外部。因此，在同一个类的其他方法中也可以使用这个常量
        //注意：const是Java的保留关键字，但目前没有使用

        //在默认情况下，虚拟机设计者允许对中间计算结果采用扩展的精度
        //但是，对于使用strictfp关键字标记的方法必须使用严格的浮点计算来生成可再生的结果
        //例如：可以把main方法标记为public static strictfp void main (String[] args)
        //于是在main方法中的所有指令都将使用严格的浮点计算，如果将一个类标记为strictfp，这个类所有的方法都要使用严格的浮点计算

        //实际的计算方式将取决于Intel处理器的行为，在默认情况下，中间结果允许使用扩展的指数
        //区别是使用默认的方式不会产生溢出，而采用严格的计算有可能出现溢出

        //在Math类中，包含了各种各样的数学数函数
        //例如 Math.sqrt(x)
        //注意：println方法处理System.out对象，但是Math类中sqrt方法处理的不是对象，而是一个静态方法
        //在Java中没有幂运算：需要使用Math.pow()

        //Math中的floorMod是改进版本的%，防止被除数为负数而导致结果为负数的情况，但如果除数是负，结果也仍是负数
        //Math中也提供了一些常用的三角函数
        //Math.sin//Math.cos//Math.tan//Math.atan//Math.atan2
        //还有指数函数以及它的反函数
        //Math.exp//Math.log//Math.log10
        //最后还提供了两个用于表示PI与e常量的近似值
        //Math.PI//Math.E

        //提示：不必在数学方法名和常量名前添加前缀Math，只要在源文件的顶部加上
        //import static java.lang.Math.*;

        //经常需要将一种数值类型转换为另一种数值类型
        //当两个数值进行二元操作运算时，首先将两个操作数转换为同一种类型
        //•如果两个操作数中有一个是 double 类型， 另一个操作数就会转换为 double 类型。
        //•否则，如果其中一个操作数是 float 类型，另一个操作数将会转换为 float 类型。
        //•否则，如果其中一个操作数是 long 类型， 另一个操作数将会转换为 long 类型。
        //•否则，两个操作数都将被转换为 int 类型
        //也就是说char byte short 都会至少转换为int

        //强制类型转换（可能 会丢失一些信息）注意：强制类型转换会截取整数部分而忽略小数
        //例如：int nx = (int) x;
        //如果想对浮点数进行舍入运算，需要使用Math.round() 注意：返回类型是long
        //注意：如果试图将一个数值从一种类型强制转换为另一种而又超出了目标类型的表示范围
        //结果将会截断成一个完全不同的值如：(byte)300 == 44;

        //不要让boolean类型进行转换

        //Java沿用了C++的做法：使用&&表示与，使用||表示逻辑或，同时两者都是短路的方式来求值的
        //但也可以使用& 与 |进行逻辑运算这时不会采用短路的运算方式运算

        //位运算符
        //处理整数类型时，可以直接对组成整型类型的各个位完成操作。这意味着可以使用掩码技术得到整数中的
        //各个位： & | ^ ~
        //同时使用<< >> 可以完成位的左移与右移，最后使用>>>将会用0填充高位，与>>不同，后者会用符号位填充

        //注意：移位操作的右操作数需要完成模32的运算（如果是long类型则需要模64）例如：1<<35的值等同于1<<3 或 等同于8
        //在C++中，不能保证>>是完成算术移位还是逻辑移位，因为它没有>>>

        //与C++不同，Java不使用逗号运算符

        //枚举类型
        //enum Size {SMALL, MEDIUM, LARGE, EX_LARGE};
        //现在，可以声明这种类型的变量
        //Size s = Size.MEDIUM;
        //注意默认有一个null值：表示这个变量没有被设置任何值
    }

    public static void ExScanner1() {
        //空串与Null串
        //长度为0的“”是空串 str.length()==0;或str.equals("");
        //空串是一个Java对象，有自己的串长度0和内容空，不过String变量还可以存入一个特殊的值
        //名为null，这表示目前没有任何对象与该变量关联
        //可以使用str == null
        //有时需要检查一个字符串不是null也不是空串
        //则： if(str!=null && str.length() != 0 )
        //注意一定要先检查null否则不能在null上调用方法
        //p49

        Scanner in = new Scanner(System.in);
        System.out.println("===What is you name?===");
        String name;
        //name = in.nextLine();
        name = in.next();
        System.out.println("You name is : "+name);


        // • Scanner (InputStream in) 用给定的输人流创建一个 Scanner 对象。
        // • String nextLine( ) 读取输入的下一行内容。
        // • String next( ) 读取输入的下一个单词（以空格作为分隔符)。
        // • int nextInt( )
        // • double nextDouble( ) 读取并转换下一个表示整数或浮点数的字符序列。
        // • boolean hasNext( ) 检测输人中是否还有其他单词。
        // • boolean hasNextInt( )
        // • boolean hasNextDouble( ) 检测是否还有表示整数或浮点数的下一个字符序列。
    }

    public static void ExNullBlank() {
        //输入输出
        //想要通过控制台进行输入，首先需要构造一个Scanner对象，并与标准输入流System.in关联
        //Scanner in = new Scanner(System.in);
        //现在就可以使用Scanner类的各种方法实现输入操作了，例如nextLine方法将输入一行

        //这里使用nextLine是可以包含空格的，要想读取一个单词（以空格符为分隔符）就调用in.next();
        //如果是一个整数的话。使用nextInt();
        //类似的，浮点数使用nextDouble();
        //Scanner类定义在java.util.*;
        //import java.util.*;
        //当使用的类不是定义在基本java.lang包中时，一定使用import指示字符将相应的包加载进来

        //如果想要输入一个密码可以使用以下代码


        String test_null = null;
        //必须定义才能通过编译...
        if (test_null == null){
            System.out.println("A Null!");
        }else if(test_null.equals("")){
            System.out.println("A Blank!");
        }
    }

    public static void ExTestStringBuilder(){
        //字符串
        //Java字符串就是Unicode字符序列，Java没有内置的字符串类型，而是在标准Java类库中提供一个预定
        //义类，叫做String
        String e = "";
        //String类的substring 方法可以从一个较大的字符串中提取出一个子串
        String greeting = "hello";
        String s = greeting.substring(0,3); //hel
        Print(s);


        //拼接
        //Java使用+可以进行两个串的连接
        //注意：任何一个Java对象都可以转换成字符串
        //如果需要把多个字符串放在一起，用一个定界符分隔，可以使用静态join方法
        String all = String.join(" / ","S","M","L","XL"); //"S / M / L / XL"
        Print(all);

        //不可变字符串
        //String类没有提供用于修改字符串的方法！
        //greeting = greeting.substring(0,3)+"p!";
        //只能这样，因此String实际是不可修改字符串，类型于C++中c风格的字符串的存在
        //这样的字符串可以共享，因为放在一个公共的存储中，是一个固定的字符序列的存在

        //Java字符串大致类似于char*指针而不是char[]
        //当采用另一个字符串替换greeting时，Java代码进行下列操作
        //char* temp = malloc(6);
        //strncpy(temp, greeting, 3);
        //strncpy(temp+3, "p!", 3);
        //greeting = temp;
        //注意：greeting = "Howdy";不会产生内存的泄漏
        //原始字符串放置在堆中，但Java将自动进行垃圾回收，如果一块内存不再使用，系统最终会将其回收
        //C++string对象也自动进行内存的分配与回收，但可以修改

        //检测字符串是否相等
        //可以使用equals方法检测两个字符串是否相等
        //s.equals(t);
        //可以是字符串变量，也可以是字符串字面量
        "Hello".equals(greeting);
        //要检测两个字符串是否相等但不区分大小写可以使用equalsIgnoreCase
        //"a".equalsIgnoreCase("Hello");
        //注意：一定不要使用==运算符，但C++中的string对象可以（符号重载）
        //也可以使用类型C的strcmp的compareTo() == 0

        //char类型是Java字符串的组成元素，char类型类型是一个采用UTF-16编码表示Unicode码点的代码单元
        //大多常用Unicode字符使用一个代码单元就可以表示，而辅助字符需要一对代码单元表示
        //length方法返回采用utf-16编码表示的给定字符串所需要的代码单元数量
        //例如“Hello”的length是5

        //若想要得到码点的数量，即实际长度，可以调用
        greeting = "⑪一二三四五";
        int cpCount = greeting.codePointCount(0, greeting.length());
        Print("12345的长度： " + cpCount);
        //调用s.charAt(n)返回位置n的代码单元，n介于0~s,length()-1之间
        //要想得到第i个码点，应该使用下列语句
        //offsetByCodePoints完全没有意思 价值...
        int index = greeting.offsetByCodePoints(1,2);
        int cp = greeting.codePointAt(index);
        Print("12345的第2个码点的下标是："+index+"\r\n此处的码点是："+cp);
        int[] testPoints = greeting.codePoints().toArray();
        Print("codePoints()返回的流：");
        for (int x=0;x<testPoints.length;++x) {
            System.out.print(" "+testPoints[x]);
        }
        System.out.println();

        //与C一样代码单元与码点从0开始计数
        //如果要遍历一个字符串，并且依次查看每一个码点，可以使用下列语句
        String sentence = "哈，悄好";
        int i = 0;
        int cpp = sentence.codePointAt(2);
        if (Character.isSupplementaryCodePoint(cpp)) i+=2;
        else i++;
        Print("sentence的下标为2的处的码点是："+cpp+"\r\n之后i= "+i);

        //可以使用下列语句实现回退操作
        //i--;
        //if(Character.isSurrogate(sentence.charAt(i))) i--;
        //int cp = sentence.codePointAt(i);

        //但上述方法很麻烦，更容易的方法是使用codePoints方法，它会生成一个int值的“流”
        //每个int值对应一个码点。可以将它转换为一个数组，再完成遍历
        int[] codePoints = sentence.codePoints().toArray();
        //反之，要把一个码点数组转换为一个字符串，可以使用构造函数
        String str2 = new String(codePoints,0,codePoints.length);
        Print("codePoints()返回的流：");
        for (int x=0;x<codePoints.length;++x) {
            System.out.print(" "+codePoints[x]);
        }
        System.out.println();

        //String API
        //Java中String类包含了50多个方法，常用的方法以下
        //每一个API的注释都以形如java.lang.String的类名开始。
        //类名之后是一个或多个方法的名字 解释和参数描述

        // • char charAt (int index) 返回给定位置的代码单元。除非对底层的代码单元感兴趣， 否则不需要调用这个 方法。
        // • int codePointAt(int Index) 5.0 返回从给定位置开始的码点。
        // • int offsetByCodePoints(int startlndex, int cpCount) 5.0 返回从 startlndex 代码点开始，位移 cpCount 后的码点索引。
        // • int compareTo(String other) 按照字典顺序，如果字符串位于 other 之前，返回一个负数；如果字符串位于 other 之 后，返回一个正数；如果两个字符串相等，返回 0。
        // • IntStream codePoints() 8 将这个字符串的码点作为一个流返回。调用 toArray将它们放在一个数组中。
        // • new String(int[] codePoints, int offset, int count) 5.0 用数组中从 offset 开始的 count 个码点构造一个字符串。
        // • boolean equals(0bject other) 如果字符串与 other 相等， 返回 true。
        // •boolean equalsIgnoreCase(String other) 如果字符串与 other 相等 （忽略大小写)， 返回 tme。
        // •boolean startsWith(String prefix )
        // •boolean endsWith(String suffix ) 如果字符串以 suffix 开头或结尾， 则返回 true。
        // •int indexOf(String str)
        // •int indexOf(String str, int fromlndex)
        // •int indexOf(int cp)
        // •int indexOf(int cp, int fromlndex) 返回与字符串 str 或代码点 cp 匹配的第一个子串的开始位置。这个位置从索引 0 或 fromlndex 开始计算。 如果在原始串中不存在 str， 返回 -1。
        // •int 1astIndexOf(String str)
        // •Int 1astIndexOf(String str, int fromlndex)
        // •int lastindexOf(int cp)
        // •int 1astindexOf(int cp, int fromlndex) 返回与字符串 str 或代码点 cp 匹配的最后一个子串的开始位置。这个位置从原始串尾 端或 fromlndex 开始计算。
        // •int 1ength( ) 返回字符串的长度。
        // •int codePointCount(int startlndex, int endlndex) 5.0 返回 startlndex 和 endludex-l 之间的代码点数量。没有配成对的代用字符将计入代码点。 參 String replace(CharSequence oldString,CharSequence newString) 返回一个新字符串。这个字符串用 newString 代替原始字符串中所有的 oldString。可 以用 String 或 StringBuilder 对象作为 CharSequence 参数。
        // •String substring(int beginlndex) 參 String substring(int beginlndex, int endlndex) 返回一个新字符串。这个字符串包含原始字符串中从 beginlndex 到串尾或 endlndex-l 的所有代码单元。
        // •String toLowerCase( ) 參 String toUpperCase( ) 返回一个新字符串。这个字符串将原始字符串中的大写字母改为小写，或者将原始字 符串中的所有小写字母改成了大写字母。
        // •String trim( ) 返回一个新字符串。这个字符串将删除了原始字符串头部和尾部的空格。
        // •String join(CharSequence delimiter, CharSequence... elements) 8 返回一个新字符串， 用给定的定界符连接所有元素。

        //构建字符串
        //每次连接字符串都会构建一个新的String对象，既耗时又浪费空间
        //使用StringBuilder类可以避免这个问题发生
        //首先构建一个空的字符串构建器：
        //StringBuilder builder = new StringBuilder();
        //当每次需要添加一部分内容时需要调用append方法
        //builder.append(ch); //appends a single character
        //builder.append(str); //appends a string

        //在需要构建字符串时就调用toString方法，将可以得到一个String对象，其中包含了构建器
        //中的字符序列
        //String completedString = builder.toString();
        StringBuilder test_build = new StringBuilder();
        for (int x = 0; x < 10 ; ++x){
            test_build.appendCodePoint(x+65);
            test_build.append("/");
        }
        Print(test_build.toString());
        //StringBuilder类是5.0中引入的，前身是StringBuffer其效率稍有些低，但允许采用多线程的方式
        //执行添加或删除字符的操作，如果所有字符串在一个单线程中编辑，则应该使用StringBuilder代替它，
        //这两个类的API是相同的

        // • StringBuilder() 构造一个空的字符串构建器。
        // • int length() 返回构建器或缓冲器中的代码单元数量。
        // • StringBui1der append(String str) 追加一个字符串并返回 this。
        // • StringBui1der append(char c) 追加一个代码单元并返回 this。
        // • StringBui1der appendCodePoint(int cp) 追加一个代码点，并将其转换为一个或两个代码单元并返回 this。
        // • void setCharAt(int i,char c) 将第 i 个代码单元设置为 c。
        // • StringBui1der insert(int offset,String str) 在 offset 位置插入一个字符串并返回 this。
        // • StringBuilder insert(int offset,Char c) 在 offset 位置插入一个代码单元并返回 this。
        // • StringBui1der delete(1nt startindex,int endlndex) 删除偏移量从 startindex 到-endlndex-1 的代码单元并返回 this。
        // • String toString() 返回一个与构建器或缓冲器内容相同的字符串
        //p55
    }

    public static void ExConsole(){
        Console cons = System.console();
        //实际使用IDE直接调试无法获取控制台
        //当使用cmd调用java执行时可以获取
        //此时密码是不可见的 直接打印也是乱码
        if (cons != null) {
            String username = cons.readLine("User name: ");
            char[] passwd = cons.readPassword("Password: ");

            Print("Welcome: "+username);
            Print("PS: "+new String(passwd));
        }

        // • static Console console( ) 6
        // 如果有可能进行交互操作， 就通过控制台窗口为交互的用户返回一个 Console 对象， 否则返回 null。对于任何一个通过控制台窗口启动的程序， 都可使用 Console对象。 否则，其可用性将与所使用的系统有关s
        // • static char[] readPassword(String prompt, Object...args)
        // • static String readLine(String prompt, Object...args)
        // 显示字符串 prompt 并且读取用户输入，直到输入行结束。args 参数可以用来提供输人 格式。有关这部分内容将在下一节中介绍。
    }

    public static void ExFormatOutput(){
        double x = 10000.0/3;
        System.out.println(x);
        Print(""+ x);
        System.out.printf("%8.2f",x);
        //p58

        //在格式化输出时以%字符开始的格式说明符用相应的参数替换
        //f表示浮点数 s表示字符串 d表示十进制整数
        //x表示十六进制 e指数浮点数 a十六进制浮点数
        //c表示字符 b表示boolean h表示散列码
        //另外可以给出控制格式化输出的各种标志
        //例如逗号标志增加了分组的分隔符
        System.out.println();
        System.out.printf("%,.2f",x);

        //+打印正数与负数的符号
        System.out.println();
        System.out.printf("%+f",x);
        //空格在正数之前添加空格,只能加一个
        System.out.println();
        System.out.printf("% f",x);
        //-左对齐 //实际不能通过编译
        System.out.println();
        System.out.printf("%f",x);
        //将负数括在括号内 正数没有效果
        System.out.println();
        System.out.printf("%(f",-x);
        //#包含小数点（对f格式）对(x或o格式)添加0x或0
        System.out.println();
        System.out.printf("%#f",x);
        System.out.println();
        System.out.printf("%#x",16);
        System.out.println();
        System.out.printf("%#o",8);
        //给定被格式化的参数索引
        //如：%1$d,%1$x将以10进制与16进制打印第一个参数【参数索引从1开始而不是0】
        //<
        //格式化前面说明的数值。例如,%d%<x以10进制与16进制打印同一个数值

        //可以使用s转换符格式化任意的对象，对于任意实现了Formattable接口的对象都将调用formatTo方法
        //否则将调用toString方法

        //可以使用静态的String.format方法创建一个格式化的字符串而不打印输出:
        String name = "Wu";
        //注意Java不支持自动的类型转换(大转小也不可)
        //float age = (float) 15.1; //不强制转换也是错的
        //说明字面值的浮点数使用的double范围
        int age = 16;
        String message = String.format("Hello, %s, Next year, you'll be %d", name, age);
        Print(message);

        //此外还支持日期的格式化但废弃
        //例如 tc（完整的日期时间） tF（ISO 8601日期） tD（美国格式的日期） tT(24小时时间)
        //。。。
        //%（?$1$）(标志+)（宽度8）（.精度.5）（转换字符f）


    }

    public static void ExFileIO(){
        //文件输入与输出
        //需要一个用File对象构造一个Scanner对象
        try {
            String dir = System.getProperty("user.dir");
            Print(dir);
            Scanner in = new Scanner(Paths.get(FileDir + "myfile.txt"), "UTF-8");

            Print("Content:");
            System.out.println(in.nextLine());
            //如果文件名中包含反斜杠，要在每个反斜杠之前再加一个额外的反斜杠
            //c:\\mydirectory\\myfile.txt

            //如果想要写入一个文件，需要构造一个PrintWriter对象，在构造器中，只需要提供文件名
            //PrintWriter out = new PrintWriter("myfile.txt","UTF-8");
            //如果不存在就创建该文件，可以像输出到System.out一样使用print println以及printf命令
            //注意：可以构造一个带有字符串参数的Scanner，但这个Scanner将字符串解释为数据，而不是文件名
            //例如：如果调用 Scanner in = new Scanner("myfile.txt");
            //这个scanner会将参数作为包含10个字符的数据而不是文件，需要使用Paths.get()方法

            //当指定一个相对文件名时，例如"myfile.txt"或"../xx"
            //文件位于Java虚拟机启动路径的相对位置，如果在命令行方式下使用下列命令启动程序
            //java MyProg
            //启动路径就是命令解释器的当前路径，然而如果使用IDE，那么启动路径由IDE控制。可以使用下面的调用方式找到路径的位置
            //String dir = System.getProperty("user.dir");

            //记住：如果用一个不存在的文件构造一个Scanner或用一个不能被创建的文件名构造一个PrintWriter那么应付引发
            //异常
        }
        catch (java.io.IOException e){

            Print("File IO filed!");
            Print("Now Create it:");

            try {
                System.out.println("Please write:");
                Scanner in = new Scanner(System.in);
                String content = in.nextLine();
                PrintWriter out = new PrintWriter(FileDir + "myfile.txt", StandardCharsets.UTF_8);
                out.println(content);
                //注意一定要用close结束，否则内容不会得到保存
                out.close();

                //注意
                //当采用命令行方式启动一个程序时，可以使用Shell的重定向语法将任意文件
                //关联到System.in与System.out:
                //重要：
                //java MyProg < myfile.txt > output.txt
                //这样就不必担心处理IOException异常了

                // Scanner(File f) 构造一个从给定文件读取数据的 Scanner。 參
                // Scanner(String data) 构造一个从给定字符串读取数据的 Scanner。
                // 类似于C++的stringstream

                // PrintWriter(String fileName) 构造一个将数据写入文件的 PrintWriter。文件名由参数指定。

                // •static Path get(String pathname) 根据给定的路径名构造一个 Path。

            }
            catch (IOException ee) {
                Print("Cant't create it...");
            }
        }

    }

    public static void ExControlPath() {
        //p63
        //与C++的控制流程结构一样，只有很少的例外情况，没有goto语句，但break语句可以带标签
        //可以利用这个实现从内层循环跳出的目的（这种情况C语言采用goto语句实现）。另外，还有一种变形
        //的for循环，在C或C++中没有这类循环，有点类似于C#的foreach循环

        //块：block
        //即复合语句：是指一对大括号括起来的Java语句，块确定了变量的作用域
        //注意:不能在嵌套的两个块中声明同名的变量:
        // 如下代码不能通过编译
//        {
//            int n;
//            {
//                int n;
//            }
//        }
        //C++中可以声明同名的变量在两个嵌套的块中
        //if与C++一样
        //else子句与最邻近的if构成一组
        //没有elseif这个关键字 只有 else if


        //循环
        //do{}while();
        //for循环是支持迭代的一种通用结构，利用每次迭代之后更新的计数器
        //或类似的变量来控制迭代的次数
        //注意：在循环中：检测两个浮点数是否相等需要格外小心
        //因为精度的原因可能永远不能结束

        //多重选择switch
//        int choice;
//        switch (choice){
//            case 0:
//                break;
//            case 1:
//                break;
//            default:
//                break;
//        }
        //因为break的必需，可能会引发错误
        //case的标签可以是：类型为char byte short int的常量表达式
        //枚举常量
        //从Java SE7 开始 case标签还可以是字符串字面量
        //使用枚举时不必在每个标签中指明枚举名
        //Size sz;
        //switch(sz)
        //{
        //  case SMALL: //不需要使用Size.SMALL

        //中断控制流程语句
        //break
        //与C++不同 Java提供了一种带标签的break语句
        //用于跳出多重嵌套的循环语句
        //注意：标签必须放在希望跳出的最外层循环之前，并且必须紧跟一个冒号
        //当使用break 标签后：会跳转到带标签的语句块的末尾
        //read_date:
        //while(..){...break read_date;}
        //something()//break后执行此句
        //只能跳出语句块 不能跳入语句块
        //continue
        //将控制转移到最内层循环的首部

    }

    public static void ExBigNum(){
        //可以使用java.math包中的两个有用的类
        //BigInteger和BigDecimal
        //这两个类可以处理包含任意长度数字序列的数值
        //使用静态的valueOf方法可以将普通的数值转换为大数值
        BigInteger a = BigInteger.valueOf(100);
        //不过不能使用+ *这些运算符处理大数值
        BigInteger b = BigInteger.valueOf(2);
        BigInteger c = a.add(b);
        BigInteger d = c.multiply(b.add(BigInteger.valueOf(2)));
        //与C++不同，Java没有提供运算符重载功能，因此只能使用方法进行计算
        //但的确在字符串连接重载了+运算符

        // • BigInteger add(BigInteger other)
        // • BigInteger subtract(BigInteger other)
        // • BigInteger multiply(BigInteger other)
        // • BigInteger divide(BigInteger other)
        // • BigInteger mod(BigInteger other) 返冋这个大整数和另一个大整数 other•的和、差、 积、 商以及余数。
        // • int compareTo(BigInteger other) 如果这个大整数与另一个大整数 other 相等， 返回 0; 如果这个大整数小于另一个大整 数 other, 返回负数； 否则， 返回正数。
        // • static BigInteger valueOf(1ong x) 返回值等于 x 的大整数。

    }

    public static void ExNumGroup(){
        //数组
        //Java的数组是一个复杂的数据结构 由length公共成员，以及众多的方法可以看出
        //而C++的内置数组（非array）完全可以看作一连串的数据区域，只有第一个元素的内存地址（指针）
        int[] a;//只是声明了变量a，并没有将a初始化为一个真正的数组
        //int aa[];//也可以 不推荐
        //应该使用new运算符创建数组
        int []b = new int[100];
        //int b[100]; //这样的语句在Java中是不合法的
        //在C++中，这个语句有声明也同时进行了定义（栈空间上的内存分配）但是没有初始化分配的内存，不能直接使用
        //在Java中，没有声明与定义的区别，但有初始化之分，并且由初始化决定变量的“大小”
        //而C++中的内置数组声明定义需要大小这个信息

        //同时使用new int[]时不要求是常量：new int[n]会创建一个长度为n的数组
        //与C++的new可能类似，都是在堆中分配的内存，但Java会直接初始化分配的内存为类型默认值
        //对于String类型，则会初始化为一个特殊的值null表示这些元素还未存放任何对象
        String[] names = new String[2];
        if(names[0]==null){
            System.out.println("IS NULL!");//会输出IS NULL
        }

        //一旦创建了数组就不能改变大小,否则使用数组列表(array list)
        //如果创建了一个100个元素的数组，并且试图访问元素a[100]
        //程序会引发“array index out of bounds”异常
        //array.length可以获得长度 注意是一个公共的成员变量不是一个方法
        //
        //for(int i =0; i<a.length; i++)

        //for each循环
        //Java有一种功能很强的循环结构，可以用来依次处理数组中的每个元素
        //其他类型元素集合也可
        //for(variable: collection) statement
        //collection这一集合表达式必须是一个数组或是一个实现了Iterable接口的类对象
        //例如ArrayList
        for(int element:b){
            //do something
        }
        //不过C++11也有相似的语法
        //有一个更加简单的方式打印数组中的所有值：利用Arrays类的toString方法
        //调用Arrays.toString(a)返回一个包含数组元素的字符串，这些元素被放置在括号内
        //用逗号分隔，例如："[2,3,4,5,6]"

        //数组初始化以及匿名数组
        //在Java中，提供了一种创建数组对象并同赋予初始值 的简化书写形式
        int[] smallPrimes = {2,3,5,7,11,13};
        //与C++相似，不需要使用new
        //甚至可以初始化一个匿名数组
        //new int[] {2,3,4,5,6,7}
        //这种表示法将创建一个新数组并利用括号中提供的值进行初始化

        //在Java中允许数组的长度为0，在编写一个结果为数组的方法时
        //如果碰巧结果为空就可以使用长度为0的数组
        //new elementType[0];
        //注意：数组长度为0与null不同

        //数组拷贝
        //在Java中，允许将一个数组变量拷贝给另一个数组变量，这时两个变量将引用同一个数组
        //即浅拷贝
        //如果希望深拷贝
        //需要使用Arrays类的copyOf方法
        int[] luckyNumbers = new int[] {2,3,4};
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        //第2个参数是新数组的长度，这个方法通常用于增加数组的大小
        luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
        //如果数组元素是数值型，那么多余的元素将被赋值为0，如果数组元素是boolean则为false
        //相反，如果长度小于原始数组的长度，则只拷贝最前面的数据元素

        //注意：Java数组与C++数组在堆栈上有很大不同
        //但基本上与分配在堆(heap)的数组指针一样
        //即
        //int[] a = new int[100];//java
        //不同于
        //int a[100];//C++
        //而等同于
        //int *a = new int[100];//C++
        //Java中的【】运算符被预定义为检查数组边界，而且没有指针运算
        //即不能通过a加1得到数组的下一个元素
    }

    public static void ExCMDParam(){
        //每一个Java应用程序都有一个带String arg[]参数的main方法
        //这个参数表明接收一个字符串数组，也就是命令行参数
        //与C++的数组不同，Java的数组是一个类，因此不同与C++的入口函数的两个形参函数
        //与C++不同，第一个参数不是程序名【即下标为0处】而是第一个参数
    }

    public static void ExNumGroupSort(){
        //想要对数值数组进行排序，可以使用Arrays类的sort方法
        int[] a = new int[]{1,2,54,4,5};
        Arrays.sort(a);//此方法使用了优化的快速排序算法
        //Math.random方法将返回一个0-1的不含1的随机浮点数
        int r = (int)(Math.random() * 10);

        // •static String toString(type[]a) 5.0
        // 返回包含 a 中数据元素的字符串， 这些数据元素被放在括号内， 并用逗号分隔。
        // 参数： a 类型为 int、long、short、char、 byte、boolean、float 或 double 的数组。
        // •static type copyOf(type[]a, int length)6
        // •static type copyOfRange(type[]a, int start, int end)6
        // 返回与 a 类型相同的一个数组， 其长度为 length 或者 end-start， 数组元素为 a 的值。
        // 参数：a 类型为 int、 long、short、char、byte、boolean、float 或 double 的数组。
        // start 起始下标（包含这个值）
        // end 终止下标（不包含这个值）。
        // 这个值可能大于 a.length。在这种情况 下，结果为 0 或 false。
        // length 的数据元素长度c 如果 length 值大于 a.length， (多的初始化)结果为 0 或 false ; 否则， 数组中只有前面 length 个数据元素的拷W值。 參
        // static void sort(type[] a)
        // 采用优化的快速排序算法对数组进行排序。 参数：a 类型为 int、long、short、char、byte、boolean、float 或 double 的数组。
        // •static int binarySearch(type[] a, type v)
        // •static int binarySearch(type[]a, int start, int end, type v) 6
        // 采用二分搜索算法查找值 v。如果查找成功， 则返回相应的下标值；
        // 否则， 返回一个 负数值 r。-r-1 是为保持 a 有序 v 应插入的位置。
        // 参数：a 类型为 int、 long、short、 char、 byte、boolean、float 或 double 的有 序数组。
        // start 起始下标（包含这个值） 。 end 终止下标（不包含这个值)。
        // v 同 a 的数据元素类型相同的值。
        // •static void fi11(type[]a, type v)
        // 将数组的所有数据元素值设置为 V。 参数：a 类型为 int、long、short、char、byte、boolean、float 或 double 的数组。
        // v 与 a 数据元素类型相同的一个值。
        // •static boolean equals(type[]a, type[]b)
        // 如果两个数组大小相同， 并且下标相同的元素都对应相等， 返回 true。 参数：a、 b 类型为 int、long、short、char、byte、boolean、float 或 double 的两个数组。

        //多维数组
        double[][] balances;
        //与一维数组一样，在调用new对多维数组进行初始化之前不能使用它
        //也可以使用下面的初始化方法
//        int[][] magicSquare = {
//                {16, 3, 2, 13}，
//        {5, 10, 11, 8},
//        (9, 6, 7, 12},
//        {4, 15, 14, 1} } ；

        //foreach不能自动处理二维数组中的每一个元素，至少需要两个
        //for(double[] row:a)
        //  for(double v: row)
        //要想快速打印一个二维数组的数据元素列表，可以调用
        //System.out.println(Arrays.deepToString(a));

        //不规则数组
        //Java实际上没有多维数组，只有一维数组（优势）
        //所以二维数组并不内存连续！但每一个一维数组内容连续！
        //因此可以低代价完成数组顺序的交换
        //因此可以构造每个数组大小不同的二维数组，即不规则数组
        //1
        //1 2
        //1 2 3
        //1 2 3 4

        //注意：
        //
        // double[][] balances = new double[10][6]//Java
        //不同于
        // double balances[10][6];//C++
        //而是分配了一个包含10个指针的数组
        //double ** balances = new double*[10];//C++
        //然后，指针数组的每一个元素被填充了一个包含6个数字的数组
        //不规则数组只能单独创建

    }
}
