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

insert into institution (id_institution, name, phone_number, x_coordinates, y_coordinates , description) values
    (1, 'Przychodnia Lekarska "U Stasia"' , '400500600' , 52.168 , 20.807 , 'Przychodnia przyjazna zwierzętom.'),
    (2, 'Szpital Wojewódzki' , '600600600' , 52.153 , 21.044 , 'Szpital dostosowany do potrzeb osób niepełnosprawnych.'),
    (3, 'Prywatna Klinika' , '478900790' , 52.105 , 21.243 , 'Klinika oferuje darmowy dostęp do sieci Wi-Fi na terenie budynku.'),
    (4, 'Prywatna Kliknika dr Biały' , '567234890' , 52.222 , 20.978 , 'W weekendy oddział jest nieczynny.'),
    (5, 'Szpital Wojewódzki' , '452278967' , 52.273 , 21.048 , 'Darmowy parking do 1h, każda kolejna godzina 5zł.'),
    (6, 'Przychodnia lekarska ' , '867400897' , 52.197 , 21.012 , 'Przychodnia czynna 24/7');

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

insert into form (id_form, comment, date, message, status, subject , id_doctor, id_patient,doctor_active_flag,patient_active_flag) values
    (1, 'Należy zwiększyć spożycie witaminy C.' , '2019-01-30 14:25:11' , 'Szanowny Panie Doktorze, ciągle jest mi zimno i chce mi się wiecznie spać. Co mam zrobic?' , 'Zakończone' , 'Problem' , 1 , 1,true,true),
    (2, 'Należy się umyć.' , '2019-10-16 22:43:38' , 'Nie mogę chodzić, co zrobić?' , 'Zakończone' , 'Głupie pytanie - proszę o głupią odpowiedź' , 5 , 2,1,1),
    (3, null , '2018-07-18 19:27:35' , 'Ciągle chce mi się spać i pić. Co robić?' , 'W toku' , 'Ciągły sen i pragnienie' , null , 4,1,1),
    (4, null , '2019-11-28 06:51:25' , 'Od 2 tygodni doskwiera mi przeszywający ból w przedniej części czoła.' , 'W toku' , 'Przeszywający ból głowy' , null , 1,1,1),
    (5, 'Ranę należy smarować maścią z dużą zawartością witaminy A.' , '2017-01-04 19:06:55' , 'Podczas prac ogrodowych wbiłem sobie ciupagę w stopę, co mam robić z raną?' , 'Zakończone' , 'Góralska przygoda' , 2 , 5,1,1),
    (6, null , '2019-09-05 12:42:55' , 'Nie mogę złapać oddechu, czuję jakbym się dusił.' , 'W toku' , 'Duszność' , null , 2,1,1),
    (7, 'Należy ogarniczyć spożycie alkoholu.' , '2019-06-11 09:21:55' , 'Trzęsą mi się ręce i jestem bardzo agresywny, co poradzić?' , 'Zakończone' , 'Trzęsąca agresja' , 5 , 5,1,1),
    (8, null , '2019-04-18 21:21:42' , 'Ciągle boli mnie głowa oraz mam zatkany nos, co poradzić?' , 'W toku' , 'Głowa i nos' , null , 5,1,1),
    (9, 'Zwiększyć ilość białka w diecie.' , '2019-10-28 15:09:52' , 'Pomimo ćwiczeń nie odnotowuję wzrostu masy mięśniowej.' , 'Zakończone' , 'Brak wyników' , 1 , 1,1,1),
    (10, 'Udać się na specjalizstyczne badania balistyczne.' , '2019-12-12 14:21:12' , 'Podczas chodzenia odczuwam silny ból w lewym kolanie.' , 'Zakończone' , 'Kolano' , 3 , 3,1,1),
    (11, null , '2019-07-09 05:29:25' , 'Ciągle chce mi się spać oraz trzęsie mi się powieka.' , 'W toku' , 'Sen oraz powieka' , null , 4,1,1);


insert into institution_specialization (id_institution , id_specialization) values
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (2, 10),
    (2, 9),
    (2, 8),
    (2, 7),
    (2, 6),
    (2, 3),
    (2, 2),
    (2, 1),
    (3, 1),
    (3, 2),
    (3, 3),
    (3, 4),
    (3, 5),
    (3, 6),
    (3, 7),
    (3, 8),
    (4, 1),
    (4, 2),
    (4, 3),
    (4, 4),
    (4, 5),
    (4, 6),
    (4, 7),
    (5, 3),
    (5, 4),
    (5, 5),
    (5, 6),
    (5, 8),
    (5, 9),
    (6, 10),
    (6, 1),
    (6, 3),
    (6, 4),
    (6, 6),
    (6, 7),
    (6, 8),
    (6, 9);





