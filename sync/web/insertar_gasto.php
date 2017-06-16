<?php
/**
 * Insertar un nuevo gasto en la base de datos
 */

// Constantes para construir la respuesta
const ESTADO = 'estado';
const MENSAJE = 'mensaje';
const ID_GASTO = "idGasto";

const CODIGO_EXITO = '1';
const CODIGO_FALLO = '2';

require '../data/Gastos.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    // Decodificando formato Json
    $body = json_decode(file_get_contents("php://input"), true);

    // Insertar gasto
    $idGasto = Gastos::insertRow($body);

    if ($idGasto) {
        // Código de éxito
        print json_encode(
            array(
                ESTADO => CODIGO_EXITO,
                MENSAJE => 'Creación éxitosa',
                ID_GASTO => $idGasto)

            );
    } else {
        // Código de falla
        print json_encode(
            array(
                ESTADO => CODIGO_FALLO,
                MENSAJE => 'Creación fallida')
            );
    }
}