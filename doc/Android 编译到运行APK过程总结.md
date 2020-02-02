## APK编译过程
![image]()

- 1.Android通过AAPT工具将.xml资源文件编译成R.java的二进制文件，除了assets、raw目录下的文件；
- 2.将java文件编译成.class文件；
- 3.通过dex工具将.class文件转换成.dex文件
- 4.优化dex文件 ： Davlik模式下使用 dexopt工具将.dex文件优化得到.odex文件 ; Art模式下使用dexoat工具将.dex文件优化得到.oat文件;
- 5.apkbuilder会将.dex文件和未被编译的文件编译成apk;
- 6.apkSinger对apk签名；
- 7.zipalign对签名后的apk进行优化
## APK包内容

![image]()

Android 安装的apk文件实际上是以.zip结尾的压缩文件，解压后的文件内容如上图所示

- AndroidManifest.xml对应源代码中的AndroidManifest.xml, 但这里是编译过的，文件内容已经不同了；

- assets对应源代码的assets目录， 是直接复制过来的；

- classes.dex（classes2.dex、classes3.dex等等）是包含所有Java文件对应的字节码，其中classes.dex是程序主包;

- lib目录对应源代码中的libs目录，包含so文件；

- META-INF目录包含CERT.RSA、CERT.SF、MANIFEST.MF等， 保存了各个资源文件的SHA1值，用于校验资源文件是否被篡改，从而防止二次打包时资源文件被替换；

- res目录对应源码的res目录， 包含各种图片、xml等；

- resources.arsc包含了各个资源文件的映射， 可以理解为索引， 通过该文件能找到对应的资源文件信息。

## APK运行过程

 通过ClassLoader将.dex文件加载到虚拟机中