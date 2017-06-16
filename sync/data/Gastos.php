<?php

/**
 * Representa el data de los gastos
 * almacenados en la base de datos
 */
require 'DatabaseConnection.php';

class Gastos
{
    // Nombre de la tabla asociada a esta clase
    const TABLE_NAME = "gasto";

    const MONTO = "monto";
    const ETIQUETA = "etiqueta";
    const FECHA = "fecha";
    const DESCRIPCION = "descripcion";

    function __construct(){}

    /**
     * Obtiene todos los gastos de la base de datos
     * @return array|bool Arreglo con todos los gastos o false en caso de error
     */
    public static function getAll()
    {
        $consulta = "SELECT * FROM " . self::TABLE_NAME;
        try {
            // Preparar sentencia
            $comando = DatabaseConnection::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();

            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            return false;
        }
    }

    public static function insertRow($object)
    {
        try {

            $pdo = DatabaseConnection::getInstance()->getDb();

            // Sentencia INSERT
            $comando = "INSERT INTO " . self::TABLE_NAME . " ( " .
            self::MONTO . "," .
            self::ETIQUETA . "," .
            self::FECHA . "," .
            self::DESCRIPCION . ")" .
            " VALUES(?,?,?,?)";

            // Preparar la sentencia
            $sentencia = $pdo->prepare($comando);

            $sentencia->bindParam(1, $monto);
            $sentencia->bindParam(2, $etiqueta);
            $sentencia->bindParam(3, $fecha);
            $sentencia->bindParam(4, $descripcion);

            $monto = $object[self::MONTO];
            $etiqueta = $object[self::ETIQUETA];
            $fecha = $object[self::FECHA];
            $descripcion = $object[self::DESCRIPCION];

            $sentencia->execute();

            // Retornar en el último id insertado
            return $pdo->lastInsertId();
        } catch (PDOException $e) {
            return false;
        }

    }
}

?>