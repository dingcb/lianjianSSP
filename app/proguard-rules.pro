# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

#表示混淆时不使用大小写混合类名。
-dontusemixedcaseclassnames
#表示不跳过library中的非public的类。
-dontskipnonpubliclibraryclasses
#表示打印混淆的详细信息。
-verbose

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
# 表示不进行优化，建议使用此选项，因为根据proguard-android-optimize.txt中的描述，
#优化可能会造成一些潜在风险，不能保证在所有版本的Dalvik上都正常运行。
-dontoptimize
#表示不进行预校验。这个预校验是作用在Java平台上的，Android平台上不需要这项功能，去掉之后还可以加快混淆速度
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.
#表示对注解中的参数进行保留。
-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
#表示不混淆上述声明的两个类，这两个类我们基本也用不上，是接入Google原生的一些服务时使用的。
# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
#表示不混淆任何包含native方法的类的类名以及native方法名，这个和我们刚才验证的结果是一致的。
-keepclasseswithmembernames class * {
    native <methods>;
}



## see https://github.com/evant/gradle-retrolambda for java 8
-dontwarn java.lang.invoke.*

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
#表示不混淆任何一个View中的setXxx()和getXxx()方法，因为属性动画需要有相应的setter和getter的方法实现，混淆了就无法工作了。
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
#表示不混淆Activity中参数是View的方法，因为有这样一种用法，在XML中配置android:onClick=”buttonClick”属性，
#当用户点击该按钮时就会调用Activity中的buttonClick(View view)方法，如果这个方法被混淆的话就找不到了。
#-keepclassmembers class * extends android.app.Activity {
#   public void *(android.view.View);
#}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
#表示不混淆枚举中的values()和valueOf()方法，枚举我用的非常少，这个就不评论了。
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#表示不混淆Parcelable实现类中的CREATOR字段，毫无疑问，CREATOR字段是绝对不能改变的，
#包括大小写都不能变，不然整个Parcelable工作机制都会失败。
-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

#表示不混淆R文件中的所有静态字段，我们都知道R文件是通过字段来记录每个资源的id的，字段名要是被混淆了，id也就找不着了。
-keepclassmembers class **.R$* {
    public static <fields>;
}

#LitePal作为开源库并不需要混淆，上面的配置已经演示了如何不混淆LitePal代码，
#然后所有代码中的Model是需要进行反射的，也不能混淆
-keep class * extends org.DataSupport {
    *;
}

# The support library contains references to newer platform versions.
# Dont warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
#表示对android.support包下的代码不警告，因为support包中有很多代码都是在高版本中使用的，
#如果我们的项目指定的版本比较低在打包时就会给予警告。不过support包中所有的代码都在版本兼容性上做足了判断，
#因此不用担心代码会出问题，所以直接忽略警告就可以了。
-dontwarn android.support.**

#忽略警告
    -ignorewarning

   #保持自定义控件类不被混淆
    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
    }

    #保持自定义控件类不被混淆
#    -keepclassmembers class * extends android.app.Activity {
#       public void *(android.view.View);
#    }
#    -keepclassmembers class * extends android.support.v7.app.AppCompatActivity {
#       public void *(android.view.View);
#    }

    #保持 Parcelable 不被混淆
    -keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
    }

    #保持 Serializable 不被混淆
    -keepnames class * implements java.io.Serializable

#避免混淆泛型
    -keepattributes Signature

  # 保持哪些类不被混淆
#    -keep public class * extends android.support.v7.app.Fragment
#    -keep public class * extends android.app.Fragment
#    -keep public class * extends android.app.Activity
#    -keep public class * extends android.support.v7.app.AppCompatActivity
#    -keep public class * extends android.app.Application
#    -keep public class * extends android.app.Service
    -keep public class * extends android.content.BroadcastReceiver
    -keep public class * extends android.content.ContentProvider

  # 保持哪些类不被混淆
#    -keep public class * extends com.estar.common.ui.activity.BaseActivity
#    -keep public class * extends com.estar.common.ui.fragment.BaseFragment
#    -keep public class * extends android.support.v4.app.FragmentActivity

#    keep后声明完整的类名，然后保留类中的所有内容可以使用*通配符实现，如下所示：
#        -keep class com.liantronics.ui.activity.ApplicationActiivty {
#           *;
#        }
        -keep class android.content.Intent {
           *;
        }
        #    keep后声明完整的类名，然后保留类中的所有内容可以使用*通配符实现，如下所示：
#-keep class com.bigkoo.pickerview.view.WheelOptions {
#                   *;
#                }
#实体类不混淆
    -keep class com.liantronics.model.** { *;}
    -keep class com.zhihu.matisse.internal.model.** { *;}
#    不要混淆第三方库，目前我们使用了两种方式来引入第三方库，一种是通过本地jar包引入的，
#一种是通过remote引入的，其实这两种方式没什么区别，要保留代码都可以使用**这种通配符来实现，如下所示：

# Litepal开源数据库不混淆
    -keep class org.litepal.** { *;}
#    BaseRecyclerViewAdapterHelper混淆
    -keep class com.chad.library.adapter.** { *;}
# 百度定位、百度推送不混淆
    -keep class com.baidu.** { *;}
#    微信不混淆
    -keep class com.tencent.** { *;}
    -keep class net.sourceforge.simcpux.** { *;}
#    二维码不混淆
    -keep class com.google.zxing.** { *;}
#    fastjson 包不混淆
    -keep class com.alibaba.fastjson.** { *;}
#    加载框
#    -keep class com.kprogresshud.** { *;}
#    patcher 增量升级包 不混淆
    -keep class com.dodola.patcher.** { *;}
    -keep class org.apache.commons.lang3.** { *;}
    -keep class com.patcher.Patcher {*;}
#    stickygridheaders 包不混淆
    -keep class com.tonicartos.widget.stickygridheaders.** { *;}



#    微信支付类不混淆
    -keep class com.estar.** { *;}
    -keep class com.estar.zsbx.** { *;}
#    -keep net.sourceforge.simcpux.wxapi.** { *;}
#    百度不混淆
    -keep class com.baidu.** { *;}

#这段代码的意思其实很明显，就是保留所有含有widgetClick方法的类的类名和widgetClick方法名，
#而如果某个类中没有含有widgetClick方法，那就还是会被混淆。
#    -keepclasseswithmember class * {
#        widgetClick <methods>;
#    }


#    热补丁
#    -keep class * extends java.lang.annotation.Annotation
#    -keep class com.alipay.euler.andfix.** { *; }
#    不混淆 Glide
#    -keep public class * implements com.bumptech.glide.module.GlideModule
    -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
      **[] $VALUES;
      public *;
    }


#为了避免Js调用在混淆后失效，需要添加以下混淆（将Js调用类保持不混淆）
-keepclassmembers class com.umai.taok.manager.JSBridge$AndroidAPI {
           public *;
      }
    -keepclassmembers class com.umai.taok.manager.ClientAPI {
          public *;
     }
     -keep class com.umai.taok.manager.JSBridge$AndroidAPI {
          public *;
     }
     -keep class com.umai.taok.manager.ClientAPI {
         public *;
      }

    -keepattributes *Annotation*
    -keepattributes *JavascriptInterface*

#   高德地图混淆
#    3D 地图 V5.0.0之前：
    -keep   class com.amap.api.maps.**{*;}
    -keep   class com.autonavi.amap.mapcore.*{*;}
    -keep   class com.amap.api.trace.**{*;}
#    3D 地图 V5.0.0之后：
    -keep   class com.amap.api.maps.**{*;}
    -keep   class com.autonavi.**{*;}
    -keep   class com.amap.api.trace.**{*;}
#    定位
    -keep class com.amap.api.location.**{*;}
    -keep class com.amap.api.fence.**{*;}
    -keep class com.autonavi.aps.amapapi.model.**{*;}
#    搜索
    -keep   class com.amap.api.services.**{*;}
#    2D地图
    -keep class com.amap.api.maps2d.**{*;}
    -keep class com.amap.api.mapcore2d.**{*;}
#    导航
    -keep class com.amap.api.navi.**{*;}
    -keep class com.autonavi.**{*;}

    -keep class liantronics.sspsdk.**{*;}
      #    keep后声明完整的类名，然后保留类中的所有内容可以使用*通配符实现，如下所示：
#-keep class liantronics.sspsdk.AdManager {*;}
#-keep class liantronics.sspsdk.AdListener {*;}