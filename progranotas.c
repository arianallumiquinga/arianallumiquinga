#include <stdio.h>
#include <string.h>

float validarNota();

int main() {
    
    float cal[5][3][3] = {0}; 
    char nombres[5][20];
    char asignaturas[3][20] = {"Matematicas", "Fisica", "Quimica"};
    int opc = 0, opc2 = 0;
    int contAlumnos = 0;

    do {
        printf("\n--- SISTEMA DE GESTIOn ---\n");
        printf("1. Registrar alumno\n");
        printf("2. Registrar 3 calificaciones por materia\n");
        printf("3. Promedio por alumno\n");
        printf("4. Promedio por asignatura\n");
        printf("5. Calificacion mas alta y baja por estudiante\n");
        printf("6. Calificacion mas alta y baja por asignatura\n");
        printf("7. Aprobados y Reprobados por asignatura\n");
        printf(">> ");
        scanf("%d", &opc);

        switch (opc) {
            case 1:
                if (contAlumnos < 5) {
                    printf("Nombre del alumno %d: ", contAlumnos + 1);
                    getchar();
                    fgets(nombres[contAlumnos], 20, stdin);
                    nombres[contAlumnos][strcspn(nombres[contAlumnos], "\n")] = 0;
                    contAlumnos++;
                } else printf("Numero de alumnos permitidos completo.\n");
                break;

            case 2:
                if (contAlumnos == 0) {
                    printf("No hay alumnos.\n");
                } else {
                    int selA;
                    printf("Seleccione alumno (0-%d):\n", contAlumnos - 1);
                    for (int i = 0; i < contAlumnos; i++) printf("%d. %s\n", i, nombres[i]);
                    scanf("%d", &selA);

                    if (selA >= 0 && selA < contAlumnos) {
                        for (int i = 0; i < 3; i++) { // Por cada materia
                            printf("--- %s ---\n", asignaturas[i]);
                            for (int k = 0; k < 3; k++) { // Por cada parcial
                                printf("  Nota parcial %d: ", k + 1);
                                cal[selA][i][k] = validarNota();
                            }
                        }
                    }
                }
                break;

            case 3: // Promedio por alumno
                printf("\n--- PROMEDIOS GENERALES POR ALUMNO ---\n");
                for (int i = 0; i < contAlumnos; i++) {
                    float sumaTotalEstudiante = 0;
                    for (int j = 0; j < 3; j++) {
                        float sumaMateria = 0;
                        for (int k = 0; k < 3; k++) sumaMateria += cal[i][j][k];
                        sumaTotalEstudiante += (sumaMateria / 3.0); // Promedio de la materia
                    }
                    printf("Estudiante: %-15s | Promedio General: %.2f\n", nombres[i], sumaTotalEstudiante / 3.0);
                }
                break;

            case 4: // Promedio por asignatura
                printf("\n--- PROMEDIO GRUPAL POR ASIGNATURA ---\n");
                for (int j = 0; j < 3; j++) {
                    float sumaGrupalMateria = 0;
                    for (int i = 0; i < contAlumnos; i++) {
                        float sumaNotas = 0;
                        for (int k = 0; k < 3; k++) sumaNotas += cal[i][j][k];
                        sumaGrupalMateria += (sumaNotas / 3.0);
                    }
                    if (contAlumnos > 0)
                        printf("%-12s: %.2f\n", asignaturas[j], sumaGrupalMateria / contAlumnos);
                }
                break;

            case 5: // Max/Min por estudiante (de sus promedios de materia)
                printf("\n--- CALIFICACION MAS ALTA Y BAJA POR ESTUDIANTE ---\n");
                for (int i = 0; i < contAlumnos; i++) {
                    float maxEst = cal[i][0][0];
                    float minEst = cal[i][0][0];

                    for (int j = 0; j < 3; j++) { // Materias
                        for (int k = 0; k < 3; k++) { // Notas parciales
                            if (cal[i][j][k] > maxEst) maxEst = cal[i][j][k];
                            if (cal[i][j][k] < minEst) minEst = cal[i][j][k];
                        }
                    }
                    printf("Estudiante: %-15s | Maxima: %.2f | Minima: %.2f\n", nombres[i], maxEst, minEst);
                }
                break;
            case 6: // Máx/Mín por Asignatura 
                printf("\n--- CALIFICACION MAS ALTA Y BAJA POR ASIGNATURA ---\n");
                for (int j = 0; j < 3; j++) { // Por cada materia
                    float maxAsig = cal[0][j][0];
                    float minAsig = cal[0][j][0];

                    for (int i = 0; i < contAlumnos; i++) { // Todos los alumnos
                        for (int k = 0; k < 3; k++) { // Todos los parciales
                            if (cal[i][j][k] > maxAsig) maxAsig = cal[i][j][k];
                            if (cal[i][j][k] < minAsig) minAsig = cal[i][j][k];
                        }
                    }
                    printf("Asignatura: %-12s | Maxima: %.2f | Minima: %.2f\n", asignaturas[j], maxAsig, minAsig);
                }
                break;

            case 7: // Aprobados (Promedio materia >= 6)
                for (int j = 0; j < 3; j++) {
                    int ap = 0, re = 0;
                    for (int i = 0; i < contAlumnos; i++) {
                        float prom = (cal[i][j][0] + cal[i][j][1] + cal[i][j][2]) / 3.0;
                        if (prom >= 6.0) ap++; else re++;
                    }
                    printf("%s -> Aprobados: %d | Reprobados: %d\n", asignaturas[j], ap, re);
                }
                break;
            default:
            printf("Ingrese un numero valido");
            break;
        }
        printf("\nContinuar? 1.Si / 2.No: ");
        scanf("%d", &opc2);
    } while (opc2 == 1);
    return 0;
}

float validarNota() {
    float n;
    do {
        scanf("%f", &n);
        if (n < 0 || n > 10) printf("Invalida (0-10): ");
    } while (n < 0 || n > 10);
    return n;
}