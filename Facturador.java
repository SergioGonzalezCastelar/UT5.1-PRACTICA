public class Facturador {

   
    static String[][] repertorio = { 
        {"Tributo Robe", "heavy"}, 
        {"Homenaje Queen", "pop"}, 
        {"Magia Knoppler", "rock"}, 
        {"Demonios Rojos", "heavy"} 
    };

    static Integer[][] actuaciones = {
        {0, 3000}, 
        {2, 1200}, 
        {0, 950}, 
        {3000, 1140},
        {1, 1500} 
    };

    static String cliente = "Ayuntamiento de Badajoz";

    public static void main(String[] args) throws Exception {
        Double totalFactura = 0d;
        Integer creditos = 0;

        System.out.println("FACTURA DE ACTUACIONES");
        System.out.println("Cliente: " + cliente);
        System.out.println("-------------------------------------------");

        for (int i = 0; i < actuaciones.length; i++) {
            Integer iConcierto = actuaciones[i][0];
            Integer asistentes = actuaciones[i][1];
            String nombreConcierto = repertorio[iConcierto][0];
            String tipoConcierto = repertorio[iConcierto][1];
            Double importeActuacion = 0d;

            // Lógica de cálculo según tipo de concierto
            switch (tipoConcierto) {
                case "heavy":
                    importeActuacion = 4000d;
                    if (asistentes > 500) {
                        importeActuacion += 20 * (asistentes - 500);
                    }
                    break;
                case "rock":
                    importeActuacion = 3000d;
                    if (asistentes > 1000) {
                        importeActuacion += 30 * (asistentes - 1000);
                    }
                    break;
                default:
                    throw new Exception("Tipo de concierto desconocido: ");
            }

            // Cálculo de créditos
            creditos += Math.max(asistentes - 500, 0);
            if (tipoConcierto.equals("heavy")) {
                creditos += asistentes / 5;
            }

            totalFactura += importeActuacion;

            System.out.println("\tConcierto: " + nombreConcierto + " (" + tipoConcierto + ")");
            System.out.println("\t\tAsistentes: " + asistentes);
        }

        // Resumen final (Solo se ejecutará si no hay excepción)
        System.out.println("-------------------------------------------");
        System.out.printf("BASE IMPONIBLE: %.2f euros\n", totalFactura);
        System.out.printf("IVA (21%%): %.2f euros\n", totalFactura * 0.21);
        System.out.printf("TOTAL FACTURA: %.2f euros\n", totalFactura * 1.21);
        System.out.println("Créditos obtenidos: " + creditos);
    }
}

