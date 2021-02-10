#import urllib.request as req
from urllib import request
from bs4 import BeautifulSoup
import re 

url = 'https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo'

target = request.urlopen(url)

soup = BeautifulSoup(target)

print(soup.title)
print(soup.title.String)
print(soup.img)
print(soup.img['src'])

# 검색함수 
# find() : 해당 태그의 첫번째 태그의 정보만 반환
# find_all() : 여러개의 태그 정보를 반환 - list로 

print(soup.find('a'))
print(soup.find('a', class_='logo'))
print(soup.find(id='team_LG'))

tag_1 = soup.find_all(text='순위')
print(tag_1)

tag_2 = soup.find_all(text=re.compile('순위'))
print(tag_2)

print('--------------------------------------')
for tag in soup.find_all('a'):
    #print(tag) 
    pass 

# a 테그 중 class속성이 들어가야하고 속성명이 logo인것 추출  <a class="logo"
for tag in soup.find_all('a', attrs={'class', 'logo'}):
    #print(tag) 
    pass 

# a태그와 img 태그 둘다 찾음     
for tag in soup.find_all(['a', 'img']):
    #print(tag) 
    pass 

# select td밑에 div있고 그 밑에 span있고 이 span은 id속성을 가져야한다.
for i, tag in enumerate(soup.select('td>div>span[id]'), start=1):
    print(i, '위', tag) 