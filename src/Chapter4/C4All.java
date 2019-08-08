package Chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class C4All {
    public static void main(String[] args) {
        //Do Some
        //SomeThing();

        //Create My class
        ExMyClass();

        //包p131
    }
    public static void Print(Object o){
        System.out.println("--------");
        System.out.println(o.toString());
    }

    public static void SomeThing(){
        //由类构造对象的过程叫创建类的实例
        //对象中的数据称为实例域
        //操纵数据的过程为方法
        //对于每一个特定的类实例（对象）都有一组特定的实例域值
        //这些值的集合就是这个对象的当前状态
        //注意：实现封装的方法是绝对不能让类中的方法直接访问其他类的实例域
        //程序仅仅通过对象的方法与对象数据进行交互

        //使用OOP需要清楚三个主要特征
        //对象的行为-方法
        //对象的状态-当施加哪些方法会怎样响应
        //对象的标识-如何辨别相同行为与状态的不同对象

        //类之间的关系
        //依赖：（uses-a）:一个类的方法操纵另一个类的对象【尽可能少】
        //聚合：（has-a）:一个对象包含另一个类的对象
        //继承：（is-a）

        //并不是所有类都具有面向对象的特征
        //例如Math类：Math.random
        //Math类只封装了功能，不需要也不必隐藏数据，没有数据不需要关心初始化实例域

        //要想使用对象，必须首先构造对象并指定其初始状态
        //在Java中使用构造器构造新实例：构造器是一种特殊的方法
        //用于构造并初始化对象

        //constructor的名字应该与类名一样，因此Date的constructor的名为Date
        //想要构造一个Data对象，需要在构造器前面加上new操作符
        //new Date()
        //这个对象初始化为当前的日期与时间
        //也能直接使用方法返回的对象（实例）
        //String s = new Date().toString();
        //不过这样只使用了一次new构造的对象
        //一般使用一个变量进行存储
        //
        //注意：C++中很少使用new的，一定要注意，一旦C++中使用了new关键字
        //必不可少的后面一定需要delete，C++最好使用智能指针进行管理
        //例如：std::shared_ptr<XXX> x = std::make_shared<XXX>(args);
        //std::shared_ptr<XXX>(new XXX(args));
        //std::shared_ptr<XXX> xx(new XXX(args));
        //而不同与C++，Java有垃圾回收系统，没有使用的内存会过一段时间得到释放
        //因此，在Java中大量使用了new，同C++一样 new是利用了堆内存空间
        //如果将对一个null调用方法将会引发运行时错误
        //同时注意：局部变量不会自动地初始化为null，而必须通过调用new或将他们设置为null

        //注意：Java中的引用相当于残废的C++的对象指针，而不是C++的引用
        //Date a;//Java
        //等同于
        //Date *a;//C++
        //再次提醒所有Java对象都存储在堆(heap)中一个对象包含另一个对象变量时
        //也包含了指向另一个堆对象的个指针
        //在Java中如果使用一个没有初始化的指针，运行系统会产生一个运行时的错误
        //而不是生成一个随机的结果，同时不必担心内存管理问题，由垃圾收集器处理
        //p98

        //java中LocalDate类
        //在前面的例子使用了标准类库中的Date类
        //Date类的实例有一个状态，即特定的时间点
        //时间是距离一个固定时间点毫秒数表示的
        //这个点是所谓的纪元，它是UTC时间1970年1月1日 00:00:00
        //UTC与GMT一样是一种科学标准时间
        //
        //类库设计者决定将保存时间与给时间点命名分开，所以标准Java类库分别包含了两个类
        //一个用来表示时间点的Date类，另一个是用来表示大家熟悉的日历表示法的LocalDate类
        //不要使用构造器来构造LocalDate类的对象
        //应当使用静态工厂方法代表你调用构造器
        //LocalDate.now()
        //会构造一个新对象，表示构造这个对象时的日期
        //LocalDate.of(1999,12,31)
        LocalDate newYearsEve = LocalDate.of(1999,12,31);
        //
        int year = newYearsEve.getYear();
        int month = newYearsEve.getMonthValue();
        int day = newYearsEve.getDayOfMonth();

        //这个方法会生成一个新的LocalDate对象
        //相同的 toUpperCase仍保持原字符串的不变
        newYearsEve = newYearsEve.plusDays(100);
        //GregorianCalendar是早期版本的日历处理类，其add方法是一个更改器方法（mutator method）
        //调用这个方法其状态会改变
        //相反只访问对象而不修改对象的方法有时称为访问器方法(accessor method)

        //在C++中，带有const后缀的方法是访问器方法；默认为更改器方法
        //在Java中，访问器方法与更改器方法在语法上没有明显的区别
        //
        //EXE

        LocalDate date = LocalDate.now();
        int date_day = date.getDayOfMonth();
        int this_month_length = date.lengthOfMonth();

        int date_week_num = date.getDayOfWeek().getValue();
        //Print(date_week_num);
        DayOfWeek w = DayOfWeek.SUNDAY;
        for (int i = 0;i<7;++i){
            w = w.plus(1);
            System.out.printf(" %.3s",w.name());
        }

        System.out.println();
        //从本月第一天开始
        date = date.minusDays(date_day-1);
        int first_date_week_num = date.getDayOfWeek().getValue() - 1;
        //Print(first_date_week_num);
        String blank_string = "    ";

        int times = (first_date_week_num)%7;
        while (times>0){
            System.out.print(blank_string);
            --times;
        }
        for (int i = 1;i<=this_month_length;++i){
            //必存在的东西
            if (i!=date_day)
                System.out.printf(" %2d ",i);
            else
                System.out.printf(" %2d*",i);

            if ((first_date_week_num+i)%7==0)
                System.out.println();

        }


        // •static LocalTime now( ) 构造一个表示当前日期的对象。
        // •static LocalTime of(int year, int month, int day) 构造一个表示给定日期的对象。
        // •int getYear( )
        // •int getMonthValue( )
        // •int getDayOfMonth( ) 得到当前日期的年、 月和曰。
        // •DayOfWeek getDayOfWeek 得到当前日期是星期几， 作为 DayOfWeek 类的一个实例返回。调用 getValue 来得到 1 ~ 7 之间的一个数， 表示这是星期几， 1 表示星期一， 7 表示星期日。
        // •LocalDate plusDays(int n)
        // •LocalDate minusDays(int n) 生成当前日期之后或之前 n 天的日期。

    }

    public static void ExMyClass(){
        //注意不能像使用C++一样
        //ClassName test1;//C++ 调用了默认的构造函数，并且此对象是在栈内存空间中
        //ClassName* test1;//C++ 空 nullptr
        //test1 = new ClassName(...);
        //等同于
        //ClassName test1;//Java 未初始化 不使用不会报错
        //test1 = new ClassName(...);

        ClassName test1 = new ClassName();
        ClassName test2 = new ClassName();
        ClassName test3;
        test1.PrintId();
        test1.SetId();
        test1.PrintId();
        //
        test2.PrintId();
        test2.SetId();
        test2.PrintId();
        //
        test1.PrintId();

        //
        System.out.println(ClassName.GetNextId());
    }
}

//编写主力类（workhorse class）
//通常这些类没有Main方法，却有自己的实例域与实例方法，多个类组合一起，只有一个类有main方法
//注意这个类与主类的不同：主类使用了public进行了修饰
//在一个java源文件中，只能有一个公有类，但可以有任意数目的非公有类
//使用命令行的javac时编译多个关联源文件时，可以只javac一个最上层源文件，javac会自动寻找或编译或重新编译依赖的class文件
//可以认为Java编译器内置了make功能
//public的数据域会破坏封装
class ClassName{
    public ClassName(){
        //构造器与其他方法有一个重要的不同：
        //构造方法总是伴随着new操作符的执行被调用
        //而不能对一个已经存在的对象调用构造器来达到重新设置实例域的目的

        //Java的构造器的工作方式与C++一样，但需要注意所有的Java对象都是在堆中构造的
        //总是伴随new操作符一起使用
        //注意： Class c("123");//C++，not Java
        //这条语句只能在C++中运行，在Java中错误：只能使用new
        //注意：因为Java不许可重叠域中同名变量
        //不推荐在构造器（其他类中方法也是）中定义与实例域重名的局部变量，会屏蔽实例域

        //name = "";
    }
    //调用类的对象的方法有隐式与显式的参数，隐式(implicit)的参数是.前面的对象引用变量
    //显式（explicit）的参数是方法的括号内的参数列表
    //在每一个方法中，关键字this表示隐式参数，如果需要的话可以显式表明this.name =

    //在C++中通常在类的外面定义方法:
    //void Class::Something()
    //{...}
    //如果在类的内部定义方法，这个方法将自动成为内联(inline)方法
    //而在Java中，所有方法都必须在类的内部定义，但不表示它们是内联方法，是否将某个方法
    //设置为内联方法是Java虚拟机的任务，即时编译器会监视调用那些简洁，经常被调用，没有被重载以及可优化的方法

    //经验可知：如果需要返回一个可变数据域的拷贝，应该使用clone，而不应该直接返回对象的引用
    //以防止修改private对象，破坏封装

    //基于类的访问权限
    //p111
    //前面已经知道方法可以访问所调用对象的私有数据，一个方法可以访问所属类的所有对象的私有数据
    //注意：是一个类中的方法中可以访问所有此类对象的所有数据成员
    //例如
    //class Employee{
    //public boolean equals(Employee other){
    //  return name.equals(other.name);
    //}}
    //调用方式是
    //if(harry.equals(boss))
    //此方法不仅访问了harry的私有成员，也还访问了boss的私有成员，是合法的
    //两个都是Employee类的对象
    //C++也有同样的原则：方法可以访问所属类的私有特性，而不仅限于访问隐式参数的私有特性

    //私有方法

    //final实例域
    //构建对象时必须初始化这样的域：即确保在每一个构造器执行之后，这个域的值被设置
    //并且在后面的操作中，不能够再对其进行修改
    private final String name;

    //final修饰符大都应用于基本类型域，或不可变类的域（类中每个方法都不会改变其对象）
    //例如String类就是一个不可变的类
    //对于可变的类，使用final可能会对读者造成混乱
    //例如StringBuilder()的final实例域
    //只是确定了这个对象的引用不会改变。内存区域不变，但通过这个固定的引用可以更改对象的实质内容
    //这只不过可能会造成混乱，但不代表不能这样用


    //静态域与静态方法
    //在前面给出的示例程序中，main方法都被标记为static修饰符
    //如果将域定义为static,每个类中只有一个这样的域，而每一个对象对于所有的实例域却都有自己的一份
    //拷贝(实际是一个索引，不是仅仅的内容的拷贝)，例如假定需要给每一个雇员几天赋予唯一的标识码，这里给employee类添加一个实例域id
    //和一个静态域nextId;

    private static int nextId = 1;
    private int id;
    public void SetId(){

        int id =2;
        id = 3;
        System.out.println(id);
        this.id = nextId++;
    }
    public void PrintId(){
        System.out.printf("===[%d]=== -> [%d]",id,nextId);
        System.out.println();
    }


    //现在每一个雇员对象都有自己的id域，但这个类的所有实例将共享一个nextId域
    //换句话说：如果有1000个此类的对象，则有1000个实例域id，但是只有一个静态域nextId
    //即使没有一个此类对象，静态域nextId也存在
    //在绝大多数的面向对象程序设计语言中，静态域被称为类域，static只是没用了C++的叫法
    //静态变量用得比较少，但静态常量却使用得比较多，例如在Math类中定义了一个静态常量
    //public class Math
    //{
    //  public static final double PI = 3.14....
    //}
    //另一个多次使用的静态常量是System.out，它在System类中声明
    //public static final PrintStream out = ....
    //因为是常量，因此public可以（其他的成员不推荐），因为out被声明
    //为final，所以不允许再次其他打印流赋给它
    //如果查找一下System类，可以发现有一个stOut方法，可以将System.out设置为
    //不同的流，不需要奇怪可以修改final变量的值，原因是setOut是一个本地方法。而不是用Java语言实现的
    //本地方法可以绕过Java语言的存取控制机制是一种特殊的方法在自己编程时不应当这样处理

    //静态方法是一种不能向对象实施操作的方法
    //例如Math的pow方法就是一个静态方法
    //Math.pow(x, a)
    //其实相当于没有隐式参数this
    //但可以访问类中的静态域
    public static int GetNextId(){
        return nextId;
    }

    //Java中的静态域与静态方法在功能上与C++相同，但语法书写有不同
    //在C++中使用::操作符访问自身作用域之外的静态域和静态方法
    //如：Math::PI
    //C++中第一个含义是退出一个块后依然存在的局部变量
    //static在C中的第二个含义是表示不能被其他文件访问的全局变量和函数
    //第三个含义与Java一样表示属于类但不属于类对象的变量和函数

    //注意注意：之前提到方法中变量名不能与实例域的一样，实际是可以一样的，区分的方法
    //是通过隐式的参数this来区分，方法中声明的变量会默认覆盖实例域中的变量

    //工厂方法
    //静态方法的另一种用途，类似LocalDate和NumberFormat的类使用静态工厂方法来构造对象
    //例如：LocalDate.now 和 LocalDate.of
    //使用工厂方法的原因有两个：
    //1：无法命名构造器：因为与类名一致，但希望能明显区别
    //2：当使用构造器时无法改变所构造的对象类型：可能需要一个子类

    //main（）方法：
    //注意：不需要使用对象调用静态方法，main就是一个静态方法
    //每个类可以有一个main方法，因此常用于对类进行单元测试的技巧
    //要独立测试类时，只需要java 类名，否则这个类的main方法不会得到自动执行的


    //方法参数
    //p118
    //按值调用（call by value）表示方法接收的是调用者提供的值
    //按引用调用（call by reference）表示方法接收的是调用者提供的变量地址
    //Java程序设计语言总是采用按值调用，也就是说方法得到的是拷贝
    //不像C++那样，既能传值，又能传引用
    //在Java中如果参数是一个对象的话，又因为java中的对象变量总是一个引用的存在
    //使用参数传递后，两个变量指向同一块内存区域，就可以进行内存的修改了
    //但本质并不是传引用，传引用的话相当于使用别名还能做到对原有变量的操作
    //Java中的相当于C++中的参数是一个指针而不是引用
    //总结：
    //1 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）
    //2 一个方法可以改变一个对象参数的状态
    //3 一个方法不能让对象参数引用一个新的对象

    //对象构造
    //重载构造器
    //相同的方法名，不同的参数列表，由编译器决定执行哪个方法
    //Java允许重载任何方法，而不只是构造器方法，因此要完整地描述一个方法
    //需要指出方法名以及参数类型，叫做方法的签名(signature)
    //注意返回类型不是方法签名的一部分，即不能有两个名字相同，参数类型也相同
    //担返回不同类型值的方法
    //
    //默认域初始化
    //如果在构造器中没有显式地给域赋予初值，就会被自动地赋为默认值
    //数值为0 布尔值为false 对象引用为null
    //然而最好明确
    //相比之下：C++中除非是一个全局变量，否则是不会得到默认初始化的
    //因此在一个类或一个作用域内中（成员）变量没有得到初始化就会得到一个不确定的值（内存区域仍是以前的值）
    //
    //很多类都包含一个无参数的构造函数，对象由无参数构造函数创建时，其状态会设置为适当的默认值
    //如果在编写一个类时没有编写构造器，那么系统就会提供一个无参构造器
    //这个构造器将所有的实例域设置为默认值0 false null
    //如果有自定义构造器则不会有默认构造器
    //与C++一样，无则有默认构造函数
    //它按照如下规则初始化类的数据成员
    //1.如果存在类内的初始值 用它来初始化成员
    //2.否则默认初始化该成员

    //显式域初始化
    //private String name = "";
    //在执行构造器之前，先执行赋值操作
    //初始值不一定是常量值
    //甚至可以赋值当前类的static函数返回值。。。
    //private int id = assignId();
    //private static int assignId(){return ...}

    //在C++中 不能直接初始化类的实例域（但C++11中可以有默认值，可以直接类内初始），所有的域必须在构造器中设置
    //但是有一个特殊的初始化器列表语法（初始化列表）
    //C++使用这个特殊的语法来调用域构造器，在Java中没有必要，因为对象没有子对象，只有指向其他对象的指针

    //关键字this引用方法的隐式参数，然而这个关键字还有另外一个含义
    //如果构造器的第一个语句形如this(...),这个构造器将调用同一个类的另一个构造器
    //例如：
    //public Employee(double s)
    // {
    //  this("xxxx",s);
    //   //something
    //}
    //但C++11中有 委托构造函数
    //不过是在初始化列表中体现
    //例如：Test_Delegate_Con(int b, int c) :Test_Delegate_Con(b) { y = c; }
    //
    //初始化块
    //前面已经讲过两种初始化数据域的方法
    //1 在构造器中设置值
    //2 在声明中赋值
    //3 初始化块*
    //只要构造类的对象，这些块就会被执行
    {
        //初始化块
        //name已经在前面声明了
        //这里不能通过编译
        //会提示构造器中已经分配了变量（两者只能有其一吧）
        name = "ddddd";
        //
    }
    //首先运行初始化块然后才运行构造器的主体部分
    //构造器的步骤
    //1所有数据都初始为默认值 0 false null
    //2按照在类声明中出现的次序，依次执行所有域初始化语句和初始化块
    //3如果构造器第一行调用了第二个构造器，则执行第二个构造器主体
    //4执行这个构造器的主体

    //如果对类的静态域进行初始化的代码比较复杂
    //可以使用静态的初始化块进行
    static
    {
     System.out.println("this is static...");
     nextId = 1;
    }

    //对象析构与finalize方法
    //C++有显式的析构器，其中放置一些当对象不再使用时需要执行的清理代码
    //在析构器中，最常见的操作是回收分配给对象的存储空间
    //由于Java有自动的垃圾回收器，因此不支持析构器
    //当然某些对象使用了内存之外的其他资源，例如，文件或使用了系统资源的另一个对象的句柄
    //当资源不再需要时，将其回收和再利用将显得十分重要
    //可以为任何一个类添加finalise方法，finalise方法将在垃圾回收器
    //清除对象之前调用，在实际实用中，不要依赖于使用finalize方法回收
    //任何短缺的资源，这是因为很难知道这个方法什么时候才能够调用
    //有个名为 System.mnFinalizersOnExit(true) 的方法能够确保 finalizer 方法在 Java 关 闭前被调用
    //Runtime.addShutdownHook 添加“ 关闭钓” （shutdown hook),
    //如果某个资源需要在使用完毕后立刻被关闭， 那么就需要由人工来管理。对象用完时， 可以应用一个 close方法来完成相应的清理操作。

}
