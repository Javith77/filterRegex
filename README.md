# Leerme primero
Aplicacion java escritorio.

* Se requiere de la instalacion de java para la ejecucion de este proyecto.

# Cómo empezar

### Documentación
Para mayor referencia, tenga en cuenta las siguientes secciones:

* Solo se admiten archivos con extensión .txt
* Orden y formato de estructura permitida separado por ;
    * Fecha: (YYYY-MM-DD) o (YYYY/MM/DD) rango permitido 1900 hasta 2999
    * Placa: 
        - Motocicletas o derivados: (AAA12A) (AAA-12A) (AAA 12A)
        - vehículos de servicio públicos y particular: 3 letras seguido de 3 números (AAA123) (AAA-123) (AAA 123)
        - vehículos de carga: 1 letra seguido de 4 números (A1234) (A-1234) (A 1234)
        - Remolques y semirremolques: 1 letra (R, S) seguido de 5 números (R12345) (R-12345) (R 12345) 
    * Víctimas fatales: Valor numérico positivo
    * Descripción: Debe contener por lo menos un carácter
* Formato de fecha para filtros (YYYY-MM) (YYYY/MM)

### Nota
Al cargar el archivo se verificará la estructura de cada línea, en caso de error este se mostrará en el campo (Errores de estructura del archivo) y se omite su contenido para realizar filtros.

### Expresiones regulares
Contenido de expresiones regulares utilizadas.

###### Valida la estructura del archivo (multi line, insensitive)
    /^(([1][9]\d{2})|([2]\d{3}))(-|\/)(0[1-9]|10|11|12)(-|\/)(0[1-9]|1[1-9]|2[1-9]|3[1]);([A-Z]{3}(-|\s)?\d{3}|[A-Z]{3}(-|\s)?\d{2}[a-zA-Z]|[A-Z]{1}(-|\s)?\d{4}|[A-Z]{2}(-|\s)?\d{4}|(R|S)(-|\s)?\d{5});[+]?\d+;.+/gmi
###### Valida el formato de entrada de la fecha (YYY-MM) o (YYYY/MM) en un rango de 1900 hasta 2999
    /^(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))(-|\/)(0[1-9]|10|11|12)$/gmi
###### Filtra los datos que coinciden con la fecha ingresada y placas para motocicletas o derivados ($exp1 = año ingresado) ($exp2 = mes ingresado)
    /^($exp1)(-|\/)($exp2)(-|\/)(0[1-9]|10|11|12);[A-Z]{3}(-|\s)?[0-9]{2}[A-Z].+/gmi

- Ejemplo: /^(2022)(-|\/)(10)(-|\/)(0[1-9]|10|11|12);[A-Z]{3}(-|\s)?[0-9]{2}[A-Z].+/gmi

### Manual de uso

* Ejecute la aplicación, en caso de aparecer un mensaje de Windows protegio su PC, pulse en mas informacion y luego en ejecutar de todas formas.

<!-- ![image](https://user-images.githubusercontent.com/31388947/188333327-6a17785f-6969-4f04-980e-9f5f193d097a.png) -->
<!-- ![image](https://user-images.githubusercontent.com/31388947/188333343-6a8893a0-d2bf-4afb-921c-3107f1997dbc.png) -->
   <img src="https://user-images.githubusercontent.com/31388947/188333327-6a17785f-6969-4f04-980e-9f5f193d097a.png" width="400" height="auto">
   <img src="https://user-images.githubusercontent.com/31388947/188333343-6a8893a0-d2bf-4afb-921c-3107f1997dbc.png" width="400" height="auto">


* Para seleccionar un archivo pulse en el botón Seleccionar.

   <img src="https://user-images.githubusercontent.com/31388947/188332384-503e2a33-e123-43d2-9e78-e1c784c42554.png" width="450" height="auto">
<!--    ![image](https://user-images.githubusercontent.com/31388947/188332384-503e2a33-e123-43d2-9e78-e1c784c42554.png) -->

*  Para filtrar datos ingrese la fecha con formato (YYYY-MM o YYYY/MM)  y pulse en el botón Buscar
      
    <img src="https://user-images.githubusercontent.com/31388947/188332422-09d3eece-bed6-483a-9654-e3527b3dcb13.png" width="450" height="auto">
<!--     ![image](https://user-images.githubusercontent.com/31388947/188332422-09d3eece-bed6-483a-9654-e3527b3dcb13.png) -->

* Para volver a vizualizar los datos originales deje el campo Fecha vacío y pulse en el botón Buscar.

   <img src="https://user-images.githubusercontent.com/31388947/188332452-0071f181-5e6e-493d-8587-b2f1b54f9f89.png" width="450" height="auto">
<!--    ![image](https://user-images.githubusercontent.com/31388947/188332452-0071f181-5e6e-493d-8587-b2f1b54f9f89.png) -->


### Archivo de prueba
    2022-10-01;aga 84G;15;Es una moto
    2022-10-01;AGA-85G;15;Es una moto
    2022-10-01;AGA85G;15;Es una moto
    2022-10-01;AAA123;15;Carro
    2022-10-01;AAA-123;15;Carro
    2022-10-01;AAA 123;15;Carro
    2022-09-01;AGA85G;15;Es una moto
    2022-09-01;AGA85G;15;Es una moto
    2022-10-01;T6712;15;Matricula roja
    2022-10-01;T 6712;15;Matricula roja
    2022-01-01;AGA85G;15;Es una moto
    2022-10-01;T-6712;15;Matricula roja
    2022-10-01;CC0000;15;Matricula azul
    2022-10-01;CC 0000;15;Matricula azul
    2022-10-01;CC-0000;15;Matricula azul
    2022-10-01;R 65202;15;Matricula verde
    2022-10-01;S-65202;15;Matricula verde
    2022/10/01;S65202;15;Matricula verde

    2022/10/01;S65202;15Registro malo
    2022/10/01;S652021;15;Registro malo
    2022/10/01;;15;Registro malo
    2022/10/01S6520215Registro malo
    2022 10 0;1S6520215Registro malo
