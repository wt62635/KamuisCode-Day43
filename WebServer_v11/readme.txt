本版本主要工作：
实现注册业务操作

上一个版本中，HttpRequest已经将页面表单上的数据解析完毕。
因此，我们完成ClientHandler的第二步操作，处理请求环节。
这里要添加一个新的环节，当判断请求的是一个业务时，我们就处理这个业务，
否则在判断该请求是否为一个静态资源。

