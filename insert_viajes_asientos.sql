use voyyvuelvo;

drop table asiento;
drop table viaje;
drop table usuario;

INSERT INTO viaje (origen, precio, destino, salida, num_asientos)
VALUES
('Santiago', 10000, 'Puerto Montt', '2024-12-20 10:00:00', '5');

INSERT INTO asiento (numero, disponible, viaje_id)
VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1),
(4, 1, 1),
(5, 1, 1);


INSERT INTO viaje (origen, precio, destino, salida, num_asientos)
VALUES
('Temuco', 5000, 'Valdivia', '2024-12-22 15:00:00', '5');

INSERT INTO asiento (numero, disponible, viaje_id)
VALUES
(1, 1, 2),
(2, 1, 2),
(3, 1, 2),
(4, 1, 2),
(5, 1, 2);

SELECT * FROM voyyvuelvo.asiento;
SELECT * FROM voyyvuelvo.viaje;
select * FROM voyyvuelvo.usuario;