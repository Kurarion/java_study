package Chapter3;

import java.io.Console;
import java.util.Scanner;
//import java.util.*;

public class C3All {
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
        ExFormatOutput();
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
    }
}
