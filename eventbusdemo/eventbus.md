# eventbus

1. 引入compile 'org.greenrobot:eventbus:3.1.1'
2. 接受页面注册`EventBus.getDefault().register(this);//注册eventbus、`
3. 接受页面反注册（注销）`EventBus.getDefault().unregister(this);//注销eventbus`
4. 建立事件类：ToastEvent
5. 发送信息页面：`EventBus.getDefault().post(new ToastEvent("这是发送的信息"));`发送消息
6. 接受消息,自定义一个方法接受ToastEvent，使用注解
   ```
   @Subscribe(threadMode = ThreadMode.MAIN)
   public void oneventReceiver(ToastEvent toastEvent) {
       //todo
   }
   ```

### ThreadMode详解-线程通信
1. ThreadMode.MAIN订阅者在主线程中被调用，使用此模式的事件处理程序必须快速返回以避免阻塞主线程
2. ThreadMode.ASYNC无论发布者在哪个线程，订阅者总在新的子线程中执行。EventBus内部使用了线程池，但是要尽量避免大量长时间运行的异步线程，限制并发线程数量
3. ThreadMode.BACKGROUND订阅者将在后台线程中被调用。如果发布线程不是主线程，则会在发布线程中直接调用事件处理程序方法。如果发布线程是主线程，则EventBus将使用一个后台线程来按顺序发送所有事件。使用这种模式的事件处理程序应该尽快返回以避免阻塞后台线程。
4. ThreadMode.MAIN_ORDERED订阅者在主线程中被调用
5. ThreadMode.POSTING默认，订阅者在调用post方法的线程执行，避免了线程切换，性能开销最少


MODE | Post - MainThread | post - thread1 | 备注
 --- | --- | --- | ---
 receiver-ThreadMode.POSTING| 在Mainthread|thread1|（和post一致）
 receiver-ThreadMode.MAIN|在Mainthread|在Mainthread|在mainthread
 receiver-ThreadMode.MAIN_ORDERED|在Mainthread|在Mainthread|在mainthread
 receiver-ThreadMode.BACKGROUND|在thread3|thread1|如果post在主线程，订阅者在子线程，如果post是子线程，就在post线程之中
 receiver-ThreadMode.ASYNC|在thread3|thread2|无论post在什么线程，一定在新子线程

### 配置EventBusBuilder



# Otto

### 使用
* 引入`implementation 'com.squareup:otto:1.3.8'`
* 获取Otto Bus实例，通过单例模式获取
  ```
  public class OttoBus extends Bus {

      private static OttoBus mOttoBus;


      private OttoBus() {

      }

      public static OttoBus getInstance(){
          if (mOttoBus == null) mOttoBus = new OttoBus();
          return mOttoBus;
      }


  }
  ```
* 接受页面注册Bus`OttoBus.getInstance().register(this);`
* 接受页面注销Bus`OttoBus.getInstance().unregister(this);`
* 通过@Subscribe注解接收事件的方法，参数需要跟发送事件参数一致
```
    @Subscribe
    public void receriverMsg(OttoMsgEvent ottoMsgEvent){
        log(ottoMsgEvent.getMsg());

    }
```
* 发送页面发送事件消息，通过post方法发送：`OttoBus.getInstance().post(new OttoMsgEvent("发送otto消息"));`

#### 通过@Produce注解发送消息
* 只有发送消息与上边不一致
* 必须在发送前先注册，发送完成之后注销:注册`OttoBus.getInstance().register(this);`注销：`OttoBus.getInstance().unregister(this);`
* @Produce注解方法，该方法的返回值是事件消息类型，参数必须为空
```
    @Produce
    public OttoMsgEvent sendProduceMsg() {
        return new OttoMsgEvent("来自otto produce 的消息");

    }
```

> otto可以有一个或者多个订阅者，订阅者使用@Subscribe注解方法，发出消息后，会遍历@Subscribe注解的所有方法，如果事件消息的类型一致便可以接受数据。订阅者之间接受消息是没有先后顺序的


### 线程 发送和消息处理在同一个线程
* ThreadEnforcer.ANY：可以在任意线程进行消息处理和注册、发送
* ThreadEnforcer.MAIN：默认 这样只能在主线程进行消息处理。如果在非主线程注册或者发送消息，就会抛出异常
> 默认构造方法创建的Bus只能在主线程中调用,否则报`java.lang.IllegalStateException: Event bus [Bus "default"] accessed from non-main thread null`错误


> @Subscribe注解的方法只能有一个参数
  @Subscribe注解的方法必须有具体实现，不能是个接口
  @Subscribe注解的方法必须是public的

> @Produce注解的方法入参必须是空的
  @Produce注解的方法返回值类型不能是void
  @Produce注解的方法必须是具体实现，不能是个接口
  @Produce注解的方法必须是public的
  @Produce注解的方法相同返回值类型的方法只能有一个