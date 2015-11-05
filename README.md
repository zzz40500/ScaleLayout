# ScaleLayout
按照比例显示的RelativeLayout
##需求:
 要求移动端图片宽高1:1显示.并且图片宽度要充满手机屏幕的宽度.
这个要怎么做?
[ ImageView.scaleType 的作用](http://blog.csdn.net/chen825919148/article/details/8845889) 
研究了一下 ImageView 的 scaleType 属性和常用布局.
发现貌似单单在只靠 xml 布局中不能解决的样子.


##怎么办?
方法1:
是在代码中手动的设置高度给 ImageView.
这样是一种方法.但是方法会不会太 low, 拉长了 Actitvity 的代码量?
方法2:
继承RelativeLayout控件,复写 onMeasure() 方法.


onMeasure()方法:
~~~
       @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(mScale != -1){
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthMeasureSpec) * mScale), MeasureSpec.getMode(widthMeasureSpec)));

        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

   }

~~~

####其中mScale 代表 height/width的值.   
`app:scale=`根据这个来设置高宽比(即:高/宽)    
也可以使用下面的更直观的指定高宽比:
`app:scaleProvideY`   
`app:scaleProvideX`
可以实现一样的效果    
`app:offsetY`设置偏差量,这上面比例的基础上高度要加上这个偏差量.   





#sample#
~~~
   <com.mingle.widget.ScaleLayout
        android:layout_width="fill_parent"
        app:scale="0.75"
        android:layout_height="wrap_content">

    <ImageView
        android:layout_width="fill_parent"
        android:src="@mipmap/bg"
        android:scaleType="fitXY"
        android:layout_height="fill_parent" />
    </com.mingle.widget.ScaleLayout>
~~~
用`ScaleLayout` 包裹`ImageView`,用 `app:scale` 设置宽高比:
用`android:layout_width="fill_parent"`
  `android:layout_height="fill_parent"` 设置`ImageView`,并且`scaleType`设置为`fitXY`.
  

[github](https://github.com/zzz40500/ScaleLayout)



