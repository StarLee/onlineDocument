1）采用了jodconvertor,实际调用的是本地或远程的openOffice 的服务，前提是要安装好openOffice
2）启动soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard服务
3）调用swftool进行转换为swf格式（请路径加入到环境变量）
4）http协议不支持大文件
5）选择不平台下的软件也就支持不同平台（openoffice,swftool都有linux版本）
6）文件名不支持中文，2不支持空格
7）正常是要等待完全加载完flash后才能加载内容。还有转换格式是需要时间的不能立刻得到swf文件