
# 联建光电广告 Android SDK 接入文档

## 一，SDK介绍


##### 联建光电广告SDK提供各种广告形式给客户端集成，SDK支持的广告形式包括：

* 开屏广告（API>=10）
* 插屏广告（API>=10）
* 横幅广告（API>=10）
* 视频广告（API>=14）

##### 图片格式支持：.jpeg 、.jpg 、.png 、.gif
##### 视频格式支持：.mp4

## 二，SDK接入说明

### 1、 AdSDK 包含lianjianssp.jar（位于libs目录下）:

### 2、 注册App，开发者需要注册你的App

### 3、 配置AndroidManifest.xml

>AdSDK需要的权限列表:

     <uses-permission android:name="android.permission.INTERNET"/>
     <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
     <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
     <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
     <uses-permission android:name="android.permission.GET_TASKS"/>
  
### 4、 配置Proguard

>如果要做混淆的话，需要在配置里如下的keep项

    -keep class liantronics.sspsdk.**{*;}
     
### 5、 初始化AdSdk

>在Application onCreate 时候需要初始化 AdSdk。 调用如下接口:

      AdManager.init(this);
  
## 三，SDK接口说明

### 1、开屏广告

>请求广告接口

       AdManager.showSplashAd(Activity activity, String positionId, int time, AdListener adListener);
   
>positionId　广告位ID<br>
>time　 跳转时间，默认3秒跳转<br>
>adListener　广告事件监听<br>
>参考:<br>
　　 >>1、注意在配置了开屏的activity中配置android:configChanges="keyboard|keyboardHidden|orientation|screenSize<br>
　　 >>2、开屏请求广告需要联网一段时间，在取广告期间，可以在当前界面默认显示一张全屏图，避免取开屏广告期间无内容展示，影响体验。<br>
　　

### 2、 插屏广告

>请求广告接口


    AdManager.showInterstitialAd(Activity activity, String positionId, AdListener adListener);
    
>positionId　广告位ID<br>
>adListener　广告事件监听<br>
>参考:<br>
　　 >>1、注意在配置了开屏的activity中配置android:configChanges="keyboard|keyboardHidden|orientation|screenSize<br>

### 3、 横幅广告

##### （1） 顶部横幅 请求广告接口

    AdManager.showTopBannerAd(Activity activity, String positionId,int marginTop, AdListener adListener);
    AdManager.showTopBannerAd(Activity activity, String positionId, AdListener adListener);

>marginTop　 距离系统状态栏的距离,此项可省略<br>
>positionId　广告位ID<br>
>adListener　广告事件监听<br>
>参考:<br>
　　 >>1、注意在配置了开屏的activity中配置android:configChanges="keyboard|keyboardHidden|orientation|screenSize<br>

##### （2） 底部横幅 请求广告接口
    
        AdManager.showBottomBannerAd(Activity activity, String positionId,int marginBottom, AdListener adListener);
        AdManager.showBottomBannerAd(Activity activity, String positionId, AdListener adListener);
        
>marginBottom　 距离底部的距离,此项可省略<br>
>positionId　广告位ID<br>
>adListener　广告事件监听<br>
>参考:<br>
　　 >>1、注意在配置了开屏的activity中配置android:configChanges="keyboard|keyboardHidden|orientation|screenSize<br>

### 4、 嵌入式广告

>请求广告接口

       AdManager.showEmbedAd(Activity activity, String positionId, int frameLayoutId, AdListener adListener);
    
>frameLayoutId 为嵌套容器FrameLayout的Id<br>
>positionId 广告位ID<br>
>count 请求广告数量<br>
>adListener　广告事件监听<br>
>参考:<br>
    
        < FrameLayout
        android:id="@+id/fl"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/ >
    
### 5、 关闭广告

##### （1） 关闭所有广告


    AdManager.clear();
    
##### （2） 关闭指定广告

     String tag= AdManager.showSplashAd(Activity activity, String positionId, AdListener adListener);
     AdManager.closeAd(tag);
>tag 为每个广告的唯一标签<br>
### 6、 回调接口


    /**广告回调接口*/
    public interface AdListener {
        /**成功展示回调*/
        void onAdPresent();
        /**点击回调*/
        void onAdClick();
        /**关闭回调*/
        void onAdDismissed();
        /**展示失败*/
        void onAdFailed(int code);
    }
    
### 7、 错误状态码

     101： 系统错误，请联系管理员

     102： 缺少参数

     103： 参数非法

     104： ts已过期

     105： 广告位信息不存在

     106： 广告位策略过虑

     107： sign错误

     200： 找不到符合的广告信息

     999： tagid 为空

     -100： 缺少广告注册码

     -101： 视频播放失败

     -102： 图片加载失败

     -200： 不支持此视频广告格式
