# A. Новая история

|Ограничение времени|1 секунда|
|---|---|
|Ограничение памяти|256Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

Сейчас активно развивается новая история, основателем которой является Профессор А.С. Багиров. Он выяснил, что на протяжении многих лет на земле вместе с людьми существовали ящеры. Строительство пирамид, захват Байкала и еще много разных событий произошли благодаря ящерам.

Учёные ещё не выяснили, сколько времени ящеры существовали на земле. Они находят разные данные в виде даты начала и даты окончания, и чтобы проверить их на корректность, необходимо посчитать, сколько дней ящеры существовали для двух конкретных дат. Календарь ящеров очень похож на григорианский, лишь с тем исключением, что там нет високосных годов.

Вам даны дата начала и дата окончания существования ящеров, нужно найти количество полных дней и секунд в неполном дне, чтобы учёные смогли оценить, насколько даты корректны.

## Формат ввода

В первой строке содержатся 6 целых чисел $year_1$, $month_1$, $day_1$, $hour_1$, $min_1$, $sec_1$ ($1≤year_1≤9999$, $1≤month_1≤12$, $1≤day_1≤31$,$0≤hour_1≤23$, $0≤min_1≤59$, $0≤sec_1≤59)$ — дата начала существования ящеров.

Во второй строке содержатся 6 целых чисел  $year_2$, $month_2$, $day_2$, $hour_2$, $min_2$, $sec_2$ ($1≤year_2≤9999$, $1≤month_2≤12$, $1≤day_2≤31$,$0≤hour_2≤23$, $0≤min_2≤59$, $0≤sec_2≤59)$ — дата окончания существования ящеров.

Гарантируется, что дата начала меньше, чем дата конца.

## Формат вывода

В первой и единственной строке выведите 2 числа: количество дней, сколько существовали ящеры, а также количество секунд в неполном дне.

___
# B. Разнообразие

|   |   |
|---|---|
|Ограничение времени|2 секунды|
|Ограничение памяти|256Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

Два друга A и B постоянно играют в коллекционную карточную игру (ККИ), поэтому у каждого игрока скопилась довольно большая коллекция карт.

Каждая карта в данной игре задаётся целым числом (одинаковые карты — одинаковыми числами, разные карты — разными).

Таким образом коллекцию можно представить как неупорядоченный набор целых чисел (с возможными повторениями).

После каждого изменения коллекций друзья вычисляют показатель разнообразия следующим образом:

- A и B выкладывают на стол все карты из своей коллекции в два раздельных ряда;
- Далее друзья итеративно делают следующее:
    1. Если среди лежащих на столе карт игрока A есть такая же карта, как и среди лежащих карт игрока B — каждый игрок убирает данную карту со стола;
    2. Если таковых совпадений нет — процесс заканчивается.
- Разнообразием коллекций друзья называют суммарное количество оставшихся карт на столе.

Обратите внимание: друзья убирают карты только со стола, карты не удаляются из коллекций при вычислении разнообразия.

Даны начальные состояния коллекций игроков, а также Q изменений их коллекций. После каждого изменения необходимо вычислить разнообразие коллекций друзей.

## Формат ввода

В первой строке через пробел заданы числа N, M, Q(1≤N,M,Q≤105) — количество карт в коллекциях игрока A и B и количество изменений соответственно.

Вторая строка содержит через пробел N целых чисел $a_i(1≤a_i≤109)$ — карты в коллекции игрока A.

Третья строка содержит через пробел M целых чисел $b_j(1≤b_j≤109)$ — карты в коллекции игрока B.

Далее на каждой из следующих Q строк описано изменение коллекции: через пробел заданы $type_k$ $player_k$ $card_k$ ($type_k$ = ±1; $player_k$ ∈ (A,B); 1≤ $card_k$ ≤109) — тип k-го изменения, имя игрока и значение карты:

- Если type=1, то в коллекцию игрока player добавился экземпляр карты card;
- Если type=−1, то из коллекции игрока player удалился один экземпляр карты card.
- Гарантируется, что при запросе type=−1 хотя бы один экземпляр карты card присутствует в коллекции игрока player.

## Формат вывода

Необходимо вывести через пробел Q целых чисел — разнообразие коллекций игроков A и B после k-го изменения.

___
# C. Запрос к таблице

Петя пришел на стажировку в Яндекс, и первая его задача была познакомиться с SQL.

У Пети есть табличка, состоящая из N строк и M столбцов, значениями которой являются целые числа. Каждой колонке соответствует уникальное имя — строка из латинских символов.

Пете задан запрос из Q ограничений вида: ColumnNamekqkvalk.

$q_k$ может принимать два значения:

1. > — учитывать только те строки, где значения в $ColumnName_k$ строго больше $val_k$;
2. < — учитывать только те строки, где значения в $ColumnName_k$ строго меньше $val_k$.

Задача Пети заключается в том, чтоб посчитать сумму во всех строках, которые удовлетворяют всем ограничениям. Юный стажер уже написал скрипт и вычислил ответ. Но Петя волнуется, что где-то ошибся, поэтому просит вас перепроверить его вычисления.

## Формат ввода

На первой строке вводятся 3 числа N, M, Q(1 ≤ N×M ≤ $3⋅10^5$, 1≤ Q ≤ $10^5$) — количество строк, столбцов в таблице и количество ограничений в запросе.

В следующей строке вводятся через пробел M слов, состоящих из латинских маленьких букв — название соответствующей колонки, каждая строка по длине не превосходит L (1 ≤ L ≤ 10)

Далее вводятся N строк, в каждой через пробел M целых чисел $a_{ij}$ ($−10^9≤a_{ij}≤10^9$) — элементы i-ой строки.

Потом вводятся Q строк — ограничения к запросу.

Каждая строка имеет вид $ColumnName_k$ $q_k$ $val_k$ ($q_k$ ∈(<,>); $−10^9≤val_k≤10^9$) — k-ое ограничение в формате, описанном в условии задачи.

Гарантируется, что $ColumnName_k$ соответствует имени одной из колонок таблицы.

## Формат вывода

Выведите единственное значение S — сумму всех чисел в строках, удовлетворяющих всем заданным ограничениям.

Если никакая строка не удовлетворяет всем ограничениям — выведите в ответ 0.

___
# D. Межпланетная организация

Межпланетная организация имеет иерархическую древовидную структуру:

- Корнем иерархии является генеральный директор;
- У каждого сотрудника 0 или более непосредственных подчиненных;
- Каждый сотрудник, кроме генерального директора, является непосредственным подчиненным ровно одному сотруднику.

Каждый сотрудник, кроме генерального директора, говорит либо на языке A, либо на языке B. Директор говорит на двух языках для управления всей организацией.

Структура всей организации хранится в текстовом документе. Каждый сотрудник представлен уникальным идентификатором - целым числом от 0 до N включительно, где 0 - идентификатор генерального директора.

Каждый сотрудник представлен в документе ровно два раза. Между первым и вторым вхождением идентификатора сотрудника в аналогичном формате представлены все его подчиненные.

Если у сотрудника нет подчиненных, то два его идентификатора расположены один за другим.

Например, если

- генеральный директор имеет в прямом подчинении сотрудника 1;
- сотрудник 1 имеет в прямом подчинении сотрудника 2;
- сотрудник 2 имеет в прямом подчинении сотрудников 3 и 4;

то документ будет представлен в виде строки:

`0 1 2 3 3 4 4 2 1 0`

Если при этом сотрудники 1, 3, 4 говорят на языке A, а сотрудник 2 говорит на языке B, то вся организация выглядит так:

![PIC](https://contest.yandex.ru/testsys/statement-image?imageId=a320b40aeeb845e9e85488be488db7f394b480dc8667c9a4ad22e1a84cf0a5e3)

Назовем языковым барьером сотрудника X минимальное количество начальников между X и его начальником с таким же языком.

В нашем случае сотрудники 2, 3 и 4 - имеют языковой барьер 1, т.к. у каждого из них начальник говорит на неизвестном для них языке, а сразу следующий начальник говорит на том же языке, что они. В то же время сотрудник 1 имеет языковой барьер равный 0, поскольку его начальник - это директор, который знает два языка.

Вычислить языковой барьер для каждого сотрудника в компании.

## Формат ввода

В первой строке задано целое число N(1≤N≤$10^6$) — количество сотрудников (без генерального директора).

Во второй строке через пробел задано N символов $L_i$ ($L_i$ ∈ {A,B}) — язык i-го сотрудника.

В третьей строке через пробел задано 2⋅(N+1) целых чисел $P_j$ (0 ≤ $P_j$ ≤ N) — иерархия организации в описанном в условии формате.

Гарантируется, что первый и последний элементы иерархии равны 0.

## Формат вывода

Выведите N целых чисел через пробел — языковой барьер каждого сотрудника от 1 до N включительно.

___
# E. Близость

|Язык|Ограничение времени|Ограничение памяти|Ввод|Вывод|
|---|---|---|---|---|
|Все языки|4 секунды|256Mb|стандартный ввод или input.txt|стандартный вывод или output.txt|
|Golang 1.21.0|2 секунды|256Mb|
|GNU GCC 13.1 C++20|1 секунда|256Mb|
|Clang 16.0.0 C++20|1 секунда|256Mb|

Определим близость двух целочисленных массивов как длину их наибольшего совпадающего префикса (см. примечание).

Примеры:

- Близость [1, 2, 1, 3] и [1, 2, 3, 2] равна 2 — префикс [1, 2] совпадает;
- Близость [1, 2, 3] и [3, 2, 1] равна 0.

Дано n целочисленных массивов $a_1,a_2,…,a_n$.

Необходимо вычислить сумму близостей массивов $a_i$ и $a_j$ для каждой пары 1 ≤ i < j ≤ n.

## Формат ввода

Первая строка содержит одно целое число n (1 ≤ n ≤ 3⋅$10^5$)  — количество массивов.

Каждый массив задаётся двумя строками.

Первая строка описания массива содержит единственное целое число $k_i$ (1 ≤ k ≤ 3⋅$10_5$)  — размер i-го массива.

Вторая строка описания содержит $k_i$ целых чисел $a_{ij}$ (1≤ $a_{ij}$ ≤ $10^9$) — элементы i-го массива.

Гарантируется, что $\sum_{i = 1} ^ {n} k_i ≤ 3⋅10^5$.

## Формат вывода

Выведите единственное целое число  — суммарную попарную близость массивов.