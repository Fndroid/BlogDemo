#coding=utf-8

import sys
import requests
from bs4 import BeautifulSoup
import MySQLdb

reload(sys)
sys.setdefaultencoding('utf-8')

# 定义一个博客类
class Blog:
    title = ""
    desc = ""
    postDate = ""
    status = ""

# 进行网络请求拉取源码
response = requests.get("http://www.cnblogs.com/Fndroid/")
# 使用BeautifulSoup进行处理
soup = BeautifulSoup(response.text, "html.parser")

blogs = []
# 根据源码格式爬取栏目
for day in soup.findAll(class_='day'):
    divs = day.findAll("div")
    n = 0
    b = Blog()
    for div in divs:
        if n == 0:
            # 爬取发表时间
            b.postDate = div.a.string
        elif n == 1:
            # 爬取标题
            b.title = div.a.string
        elif n == 2:
            # 爬取摘要
            b.desc = div.div.contents[0]
        elif n == 5:
            # 爬取文章状态
            b.status = div.contents[0]
        elif n == 6:
            n = 0
            blogs.append(b)
            break

        n += 1

# 连接数据库
db = MySQLdb.connect("localhost", "root", "root", "myblog", charset="utf8")
cursor = db.cursor()

for bl in blogs:
    sub_sql = "'"+bl.title+"','"+bl.desc+"','"+bl.postDate+"','"+bl.status+"'"
    # 插入数据
    sql = "insert into Blog(title,description,post_date,post_status) values("+sub_sql+")"
    try:
        cursor.execute(sql)
        db.commit()
    except:
        db.rollback()

db.close()

