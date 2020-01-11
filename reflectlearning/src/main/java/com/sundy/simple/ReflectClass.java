package com.sundy.simple;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;

import com.sundy.simple.entity.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：AndroidStudy
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-11 21:49
 * 描述：
 */
public class ReflectClass {
    private static final String TAG = "ReflectClass";

    //创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.sundy.simple.entity.Book");
            Book book = (Book) classBook.newInstance();
            book.setName("java反射练习");
            book.setAuthor("sundy");
            Log.d(TAG, "reflectNewInstance book = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有的构造方法
    public static void reflectPrivateConstructor() {
        Class<?> classBook = Book.class;
        try {
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("框架得用java反射", "sundy");
            Book book = (Book) objectBook;
            Log.d(TAG, "reflectPrivateConstructor book = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射似有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.sundy.simple.entity.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            Log.d(TAG, "reflectPrivateField tag = " + tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.sundy.simple.entity.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 1);
            Log.d(TAG, "reflectPrivateMethod string = " + string);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获得系统Zenmode值(系统勿扰模式的值)
    public static int getZenMode() {
        int zenMode = -1;
        try {
            Class<?> cServiceManager = Class.forName("android.os.ServiceManager");
            Method mGetService = cServiceManager.getMethod("getService", String.class);
            Object oNotificationManagerService = mGetService.invoke(null, Context.NOTIFICATION_SERVICE);
            Class<?> cINotificationManagerStub = Class.forName("android.app.INotificationManager$Stub");
            Method mAsInterface = cINotificationManagerStub.getMethod("asInterface", IBinder.class);
            Object oINotificationManager = mAsInterface.invoke(null, oNotificationManagerService);
            Method mGetZenMode = cINotificationManagerStub.getMethod("getZenMode");
            zenMode = (int) mGetZenMode.invoke(oINotificationManager);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return zenMode;
    }

    // 关闭手机 需要看各个版本的源码 看看源码中明确进行了权限验证需要的话就不用反射了
    public static void shutDown() {
        try {
            Class<?> cServiceManager = Class.forName("android.os.ServiceManager");
            Method mGetService = cServiceManager.getMethod("getService", String.class);
            Object oPowerManagerService = mGetService.invoke(null, Context.POWER_SERVICE);
            Class<?> cIPowerManagerStub = Class.forName("android.os.IPowerManager$Stub");
            Method mShutdown = cIPowerManagerStub.getMethod("shutdown", boolean.class, String.class, boolean.class);
            Method mAsInterface = cIPowerManagerStub.getMethod("asInterface", IBinder.class);
            Object oIPowerManager = mAsInterface.invoke(null, oPowerManagerService);
            mShutdown.invoke(oIPowerManager, true, null, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 关闭手机 需要看各个版本的源码 看看源码中明确进行了权限验证需要的话就不用反射了
    public static void shutdownOrReboot(final boolean shutdown, final boolean confirm) {
        try {
            Class<?> ServiceManager = Class.forName("android.os.ServiceManager");
            // 获得ServiceManager的getService方法
            Method getService = ServiceManager.getMethod("getService", java.lang.String.class);
            // 调用getService获取RemoteService
            Object oRemoteService = getService.invoke(null, Context.POWER_SERVICE);
            // 获得IPowerManager.Stub类
            Class<?> cStub = Class.forName("android.os.IPowerManager$Stub");
            // 获得asInterface方法
            Method asInterface = cStub.getMethod("asInterface", android.os.IBinder.class);
            // 调用asInterface方法获取IPowerManager对象
            Object oIPowerManager = asInterface.invoke(null, oRemoteService);
            if (shutdown) {
                // 获得shutdown()方法
                Method shutdownMethod = oIPowerManager.getClass().getMethod(
                        "shutdown", boolean.class, String.class, boolean.class);
                // 调用shutdown()方法
                shutdownMethod.invoke(oIPowerManager, confirm, null, false);
            } else {
                // 获得reboot()方法
                Method rebootMethod = oIPowerManager.getClass().getMethod("reboot",
                        boolean.class, String.class, boolean.class);
                // 调用reboot()方法
                rebootMethod.invoke(oIPowerManager, confirm, null, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}