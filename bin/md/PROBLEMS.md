# Java常出现的错误

## java

### 1. cannot be resolved to a variable

无法解析为变量  
    一种情况，变量名和之前声明的不一样，应该是写错了，用快捷键拼全试试  
    二种情况，数据类型出现问题，不匹配  

### 2. The method sort(int[]) in the type Arrays is not applicable for the arguments (int[], (<no type> x, <no type> y) -> {})

```java
    int[] a = new int[m];
    for (int i = 0; i < m; i++) 
        a[i] = i + 1;
    Arrays.sort(a, (x, y) -> x - y);
```

改为

```java
    Integer[] a = new Integer[m];
    for (Integer i = 0; i < m; i++)
        a[i] = i + 1;
Arrays.sort(a, (x, y) -> x - y);
```

### 3. 字符串编码问题

```java
String string = new String(str.getBytes("GBK"), "ISO-8859-1");
```