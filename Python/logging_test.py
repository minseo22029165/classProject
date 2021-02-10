import logging

# 로그 선언 
logger = logging.getLogger('main')
# 메시지의 출력 방법 정의
stream_handler = logging.StreamHandler()
# 출력 방법을 등록
logger.addHandler(stream_handler)
# 출력 레벨을 정의
logger.setLevel(logging.DEBUG)

logger.debug('debug!!')
logger.info('info!!')
logger.warning('warning!!')
logger.error('error!!')
logger.critical('critical!!')
