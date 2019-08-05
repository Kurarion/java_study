package Chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class C4All {
    public static void main(String[] args) {
        //Do Some
        SomeThing();

        //Create My class
        ExMyClass();
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

}
