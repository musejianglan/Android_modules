## andriod mvp

login仿照demo，github自己写的demo

github：
请求github用户信息

1. 输入用户名
2. 点击登录获取github用户信息，成功并将返回的用户信息展示到textview上，若失败提示失败原因
3. 点击clear按钮清空输入框及用户信息

View

### IView
onClear()//清空输入框及提示信息  
onLoginSuccess(userInfo)//将成功信息显示到提示文本上  
onLoginFail(errorInfo)//将失败信息显示到提示文本上

### IPresenter

clear()

login(username)



