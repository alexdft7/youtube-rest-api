# youtube-rest-api
Приложение Rest API (Java, Spring) для доступа к Youtube Search и Youtube Comments.

Чтобы воспользоваться им, внесите ваш Youtube API Key в youtube.properties.

Доступ к Youtube Search можно получить по адресу /search?request="{Ваш запрос}" Например: /search?request="Java"

Доступ к Youtube Comments можно получить по адресу /comments/{Id комментария} Например: /comments/Ugz-_QSqfT6KVLfLa_l4AaABAg

Уникальный Id комментария можно получить, нажав на дату его публикации или воспользовавшись Youtube CommentThreads, который позволяет вытащить до 100 комментариев за 1 запрос.
