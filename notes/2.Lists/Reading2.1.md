1.1 The Mystery of the Walrus

不会的单词：
ponder v.仔细考虑
profound adj.深奥的
subtle adj.微妙的


视频感想：
本质上跟dis2的slides中提到的一样，数据类型分primitive和reference，int 本身是primitive，所以他的盒子里面就是自己的值。但是reference的盒子其实是指向那个表示的东西的，比如array或者class。所以如果那个表示的东西改变了，指向的箭头的源头的两个盒子的值都会改变。


吐槽：md太难了


1.2 Bits

电脑在memory中储存信息
信息在memory中是一系列的0和1
e.g. 72 stored as 01001000
e.g. H stored as 01001000

72和H被保存的二进制的值都是一样的，解释器通过他们的type人想要的值是哪个


java解释器通过type来解释bits，通过被储存的0和1的队列来知道想表达的值是什么

8种原始类型在java（primitive types）:
byte short int long float double boolean char

1.2.1 Declaring a variable

当你decare一个java的特定类型时：
你的电脑首先会留出足够的bits去hold这个类型
e.g. int 会有32bits的box
e.g. double 会有64bits的box



java会有一个内部的table记录这个变量的名字从而来定位
在宣言的时候（int x/double y）的时候 java不会写任何东西在已经确保的盒子中。（无默认值）
（但实际物理上可能里面还是有些数字的，但是java不会让你访问到，就像你拿到一张已经写了些东西的便签纸，但是可能你的目的是记一个电话所以你不会在意那些草稿）

1.2.2 assignment

x = 114514
y = 2781.245
java会在盒子里面储存与这个值对应的一个二进制的一个数（0和1的序列）
int是32位的double是64位的

1.2.3 simplied Box notation

x|value（写value instead of the value in binary)

1.2.4 the Golden rule of equals

y = x :  copies all the bits from x into y
之后如果y再变了，跟x也没关系，他们是两个没联系的盒子

1.3 Object Instantiation

不懂的单词：Instantiation：具象（卑微）

当你instantiate一个object
首先会给这个class的instance variable分配两个盒子，并且填上默认值
比如new Walrus（1000，8.3）
这个instance
先创建一个weight和tuskSize的盒子，默认值是0和0.0然后通过constructor填数值
一个盒子32bit，另一个64bit，总共96bit

java首先会找96个bit，然后前面32个bit是weight的值，后面64个bit是tuskSize的值
这个new是用来return the number of bit in memory，这个instance再memory中的第几位

1.3.1 Reference Type Variable Declaration

