insert into patient(id_patient, email, name, password, pesel, phone_number, sex, surname) values
(1, 'jankowalski@wp.pl' , 'Jan' , 'janek1977' , '1' , '598231009' , 'M' , 'Kowalski'),
(2, 'karolszpital@gmail.com' , 'Karol' , 'qwertyqaz' , '88121256284' , '500200120' , 'M' , 'Owca'),
(3, 'kasiahh@onet.pl' , 'Katarzyna' , 'nohak' , '98101690992' , '789340728' , 'F' , 'Honek'),
(4, 'adammichniewicz@o2.pl' , 'Adam' , '123dom123' , '99121284002' , '698500299' , 'M' , 'Michniewicz'),
(5, 'ania.rychlik89@wp.pl' , 'Anna' , 'rychlik19890514' , '89051428231' , '606342111' , 'F' , 'Rychlik');

insert into specialization (id_specialization, name) values
    (1, 'Stomatolog'),
    (2, 'Laryngolog'),
    (3, 'Kardiolog'),
    (4, 'Diabetolog'),
    (5, 'Logopeda'),
    (6, 'Neurolog'),
    (7, 'Okulista'),
    (8, 'Seksuolog'),
    (9, 'Psychiatra'),
    (10, 'Psycholog');

insert into institution (id_institution, name, phone_number, x_coordinates, y_coordinates) values
    (1, 'Przychodnia Lekarska "U Stasia"' , '400500600' , 52.821 , 53.211),
    (2, 'Szpital Wojewódzki' , '600600600' , 55.764 , 51.733),
    (3, 'Prywatna Klinika' , '478900790' , 49.142 , 52.809);

insert into administrator (id_administrator, email, name, password, surname) values
    (1, 'admin1@twojlekarz.pl' , 'Adam' , 'admin1' , 'Gałązka'),
    (2, 'admin2@twojlekarz.pl' , 'Paweł' , 'admin2' , 'Grusza');

insert into doctor(id_doctor, email, name, password, phone_number, surname , id_institution) values
(1, 'szymonszybki@twojlekarz.pl' , 'Szymon' , 'qweewq213' , '700898201' , 'Szybki' ,  1 ),
(2, 'kacperkrzew@twojlekarz.pl' , 'Kacper' , 'kac89per12' , '567200421' , 'Krzew' ,  3),
(3, 'bartlomiejbaron@twojlekarz.pl' , 'Bartłomiej' , 'H@M@K' , '777507231' , 'Baron' , 2),
(4, 'ewelinakopytko@twojlekarz.pl' , 'Ewelina' , 'QwErTy!2#' , '678650560' , 'Kopytko' , 1 ),
(5, 'jadwigasledz@twojlekarz.pl' , 'Jadwiga' , 'qpwoeiruty' , '534753902' , 'Śledź' ,  null);

insert into doctor_specialization (id_specialization, id_doctor) values
    (1, 1),
    (1, 3),
    (1, 4),
    (2, 1),
    (2, 2),
    (2, 5),
    (3, 5);

insert into form (id_form, comment, date, message, status, subject , id_doctor, id_patient) values
    (1, 'Należy zwiększyć spożycie witaminy C.' , '2019-01-30 14:25:11' , 'Szanowny Panie Doktorze, ciągle jest mi zimno i chce mi się wiecznie spać. Co mam zrobic?' , 'Zakończone' , 'Problem' , 1 , 1),
    (2, 'Należy się umyć.' , '2019-10-16 22:43:38' , 'Nie mogę chodzić, co zrobić?' , 'Zakończone' , 'Głupie pytanie - proszę o głupią odpowiedź' , 5 , 2),
    (3, null , '2019-04-08 09:21:55' , 'Nie mogę zasnąć. Co mam na to poradzić?' , 'W toku' , 'Bezsenność' , 3 , 4);






