# Project 0 

不懂的单词：
subject to：易受
celestial ：天文的
Saturn：土星


卡壳的地方：

## 1.1The Body Class and Its Constructor

第二个constructor就卡壳了…查概念：copy constructor
目的就是为了可以方便的copy object
第一个constructor按照他给的官方写法写了，其实可以用this写更快。

## 1.3 Writing the Body Class

non-static method的写法 使用起来是：instance.method（instance）
final static的宣言

```java
final static double GRAV = 6.67e-11;
```

科学计数法的写法 1.03e-7 = 1.03 * 10^(-7)
写在class里面不要写在local method里面

写calcNetForceExertedByX and calcNetForceExertedByY的时候忽视了目标星球是自己本身的情况。
所以r变成0了没法计算了，记得用一个equals避免这个情况


for enhanced loop写法

```java
for (int i=0; i < array.length; i++) {
    System.out.println("Element: " + array[i]);
}
//new form
for (String element : array) {
    System.out.println("Element: " + element);
}
```


