import logging
import logging.config
import csv


##########################################
#logging.config.fileConfig('logging.conf')
logger = logging.getLogger()

formatter = logging.Formatterformatter('%(asctime)s %(levelname)s %(process)d %(message)s')
data_log_handler = logging.FileHandler('shop_data.log')
data_log_handler.setFormatter(formatter)

logger.addHandler(data_log_handler)
logger.setLevel()
##########################################

line_counter = 0    # csv 파일의 총 행수
data_header = []    # 리스트의 헤더
sample_list = []    # 원하는 파일만 넣기 
insert_count = 0    # 원하는 파일 갯수 

insert_list = []    # 스타벅스만 찾기

# 프로그램의 작업이 시작될때 info
logger.info('open file {}'.format('07_24_05_P_1.csv'))


# csv =-> sample_list 
try:
    with open('07_24_05_P_1.csv') as file:
        while True:
            data = file.readline().strip('\n')

            if not data:
                break

            if line_counter == 0:  # header 저장
                data_header = data.split(',')
            else:
                # 새로운 리스트에 추가할 행 
                insert_list = data.split(',')

                # 영업상태구분코드 -> 1 : 영업중, 3 : 폐업, 업태구분명 : 커피숍, 서울특별시에 위치
                if insert_list[1] == '1' and insert_list[4] == '커피숍' and insert_list[2].find(u'서울특별시') != -1:
                    sample_list.append(insert_list)
                    insert_count += 1
                    
            line_counter += 1
        logger.inf('처리완료 : 데이터 읽기')
   
except FileNotFoundError as e:
     # 파일이 없는 경우 예외 처리
     logger.error('file not found {}'.format(e))


print('line_counter', line_counter)
print('insert_count', insert_count)

for i in range(20):
    print('data-', i, ':', sample_list[i])

with open('new_shop_coffee_seoul_data.csv', 'w', encoding='utf8') as new_file: 
    writer = csv.writer(new_file, delimiter=',', quotechar="'", quoting=csv.QUOTE_ALL)
    # 해더 쓰기
    writer.writerow(data_header)
    # 내용 쓰기 
    for row in sample_list:
        writer.writerow(row)
    print('쓰기완료')
    logger.inf('처리완료 : 쓰기완료')

for shop in sample_list:
    if shop[3].find(u'스타벅스') != -1:
        insert_list.append(shop)

with open('new_coffee_star_data.csv', 'w', encoding='utf-8') as start_file:
    for star_shop in insert_list:
        start_file.write(','.join(star_shop).strip('\n') + '\n')
    print('서울_스타벅스_리스트파일 생성')
    logger.inf('처리완료 : 파일 생성 완료')
    

print('파일 작성이 완료되었습니다.')
logger.inf('처리완료 : 프로그램 실행 완료')

for s_shop in insert_list:
    print(s_shop)
