package com.historiaclinica.historiaclinica.seeders;

import com.historiaclinica.historiaclinica.entity.*;
import com.historiaclinica.historiaclinica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    //@Autowired
    //private FacultadesRepository facultadesRepository;
    @Autowired
    private UsuarioRepo ourUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //@Autowired
    //private ModulosRepository modulosRepository;
    @Autowired
    private RolRepository rolesRepository;
    @Autowired
    private PermisoRepository permisosRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private HorarioAtencionRepository horarioAtencionRepository;
    //@Autowired
    //private CarrerasRepository carrerasRepository;
    //@Autowired
    //private MateriasRepository materiasRepository;

    @Override
    public void run(String... args) throws Exception {
        // Facultades
//        if (facultadesRepository.count() == 0) {
//            Facultades facultad1 = new Facultades();
//            facultad1.setNombre("Facultad de Ingeniería en Ciencias de la Computación");
//            facultad1.setDescripcion("Facultad dedicada a la programación y gestión de sistemas");
//
//            Facultades facultad2 = new Facultades();
//            facultad2.setNombre("Facultad de Ciencias Empresariales");
//            facultad2.setDescripcion("Facultad dedicada a la administración y gestión empresarial");
//
//            facultadesRepository.save(facultad1);
//            facultadesRepository.save(facultad2);
//        }


        // ESPECIALIDADES
        // (Medicina General, Cardiología, Neurología, Pediatría, Ginecología y Obstetricia, Ortopedia, Dermatología, Psiquiatría, Endocrinología, Neumología )
        if (especialidadRepository.count() == 0) {

            Especialidad especialidad1 = new Especialidad();
            especialidad1.setNombre("Medicina General");
            especialidad1.setDescripcion("Se enfoca en el cuidado integral del paciente, abordando una variedad de problemas de salud comunes y crónicos.");
            especialidad1.setCondicionestratadas("Mantener la salud general y prevenir enfermedades.");

            Especialidad especialidad2 = new Especialidad();
            especialidad2.setNombre("Cardiología");
            especialidad2.setDescripcion("Se especializa en el diagnóstico y tratamiento de enfermedades del corazón y los vasos sanguíneos.");
            especialidad2.setCondicionestratadas("Infartos, hipertensión, arritmias, insuficiencia cardíaca.");

            Especialidad especialidad3 = new Especialidad();
            especialidad3.setNombre("Neurología");
            especialidad3.setDescripcion("Trata las enfermedades del sistema nervioso central y periférico.");
            especialidad3.setCondicionestratadas("Accidente cerebrovascular, esclerosis múltiple, Parkinson, epilepsia, migrañas.");

            Especialidad especialidad4 = new Especialidad();
            especialidad4.setNombre("Pediatría");
            especialidad4.setDescripcion("Se dedica al cuidado de la salud de los niños, desde el nacimiento hasta la adolescencia.");
            especialidad4.setCondicionestratadas("Infecciones infantiles, trastornos del crecimiento, enfermedades congénitas.");

            Especialidad especialidad5 = new Especialidad();
            especialidad5.setNombre("Ginecología y Obstetricia");
            especialidad5.setDescripcion("La ginecología se enfoca en el sistema reproductivo femenino, y la obstetricia en el embarazo y el parto.");
            especialidad5.setCondicionestratadas("Menstruación irregular, infertilidad, embarazo, parto, menopausia.");

            Especialidad especialidad6 = new Especialidad();
            especialidad6.setNombre("Dermatología");
            especialidad6.setDescripcion("Se encarga del diagnóstico y tratamiento de enfermedades de la piel, el cabello y las uñas.");
            especialidad6.setCondicionestratadas("Acne, dermatitis, psoriasis, cáncer de piel.");

            especialidadRepository.save(especialidad1);
            especialidadRepository.save(especialidad2);
            especialidadRepository.save(especialidad3);
            especialidadRepository.save(especialidad4);
            especialidadRepository.save(especialidad5);
            especialidadRepository.save(especialidad6);

        }

        // USUARIOS
        if (ourUserRepo.count() == 0) {
            //ADMIN
            Usuario admin1 = new Usuario();
            admin1.setEmail("admin@gmail.com");
            admin1.setNombre("admin");
            admin1.setPassword(passwordEncoder.encode("12345678"));
            admin1.setRole("ADMIN");

            Usuario admin2 = new Usuario();
            admin2.setEmail("admin2@gmail.com");
            admin2.setNombre("admin2");
            admin2.setPassword(passwordEncoder.encode("12345678"));
            admin2.setRole("ADMIN");

            ourUserRepo.save(admin1);
            ourUserRepo.save(admin2);

            //MEDICO
            Usuario medico1 = new Usuario();
            medico1.setEmail("medico@gmail.com");
            medico1.setNombre("medico");
            medico1.setNroLicencia("L1-3422HJ");
            medico1.setSexo(true);
            medico1.setPassword(passwordEncoder.encode("12345678"));
            medico1.setRole("MEDICO");

            Usuario medico2 = new Usuario();
            medico2.setEmail("diego@gmail.com");
            medico2.setNombre("Diego Fernandez Saucedo");
            medico2.setNroLicencia("L2-33212RT");
            medico2.setSexo(true);
            medico2.setPassword(passwordEncoder.encode("12345678"));
            medico2.setRole("MEDICO");

            Usuario medico3 = new Usuario();
            medico3.setEmail("juan@gmail.com");
            medico3.setNombre("Juan Galvez Hinojoza");
            medico3.setNroLicencia("L3-9367YU");
            medico3.setSexo(true);
            medico3.setPassword(passwordEncoder.encode("12345678"));
            medico3.setRole("MEDICO");

            Usuario medico4 = new Usuario();
            medico4.setEmail("ana@gmail.com");
            medico4.setNombre("Ana Gutierrez Delgado");
            medico4.setNroLicencia("L4-5417BG");
            medico4.setSexo(false);
            medico4.setPassword(passwordEncoder.encode("12345678"));
            medico4.setRole("MEDICO");

            Usuario medico5 = new Usuario();
            medico5.setEmail("luis.rodriguez@gmail.com");
            medico5.setNombre("Luis Rodríguez Pérez");
            medico5.setNroLicencia("L5-1234AB");
            medico5.setSexo(true);
            medico5.setPassword(passwordEncoder.encode("12345678"));
            medico5.setRole("MEDICO");

            Usuario medico6 = new Usuario();
            medico6.setEmail("sofia.martinez@gmail.com");
            medico6.setNombre("Sofía Martínez Torres");
            medico6.setNroLicencia("L6-9876CD");
            medico6.setSexo(false);
            medico6.setPassword(passwordEncoder.encode("12345678"));
            medico6.setRole("MEDICO");

            ourUserRepo.save(medico1);
            ourUserRepo.save(medico2);
            ourUserRepo.save(medico3);
            ourUserRepo.save(medico4);
            ourUserRepo.save(medico5);
            ourUserRepo.save(medico6);

            //PACIENTE
            Usuario paciente1 = new Usuario();
            paciente1.setEmail("paciente@gmail.com");
            paciente1.setNombre("paciente");
            paciente1.setTelefono("62314367");
            paciente1.setSexo(true);
            paciente1.setDireccion("Av. Ballivian 123");
            paciente1.setEdad("24");
            paciente1.setPeso("75");
            paciente1.setAltura("1.75");
            paciente1.setPassword(passwordEncoder.encode("12345678"));
            paciente1.setRole("PACIENTE");

            Usuario paciente2 = new Usuario();
            paciente2.setEmail("maria.gomez@gmail.com");
            paciente2.setNombre("María Gómez Perez");
            paciente2.setTelefono("787-65443");
            paciente2.setSexo(false);
            paciente2.setDireccion("Calle Sucre 456");
            paciente2.setEdad("28");
            paciente2.setPeso("65");
            paciente2.setAltura("1.65");
            paciente2.setPassword(passwordEncoder.encode("12345678"));
            paciente2.setRole("PACIENTE");

            Usuario paciente3 = new Usuario();
            paciente3.setEmail("carlos.ramirez@gmail.com");
            paciente3.setNombre("Carlos Ramírez");
            paciente3.setTelefono("234-5678");
            paciente3.setSexo(true);
            paciente3.setDireccion("Av. 6 de Agosto 789");
            paciente3.setEdad("45");
            paciente3.setPeso("82");
            paciente3.setAltura("1.80");
            paciente3.setPassword(passwordEncoder.encode("12345678"));
            paciente3.setRole("PACIENTE");

            Usuario paciente4 = new Usuario();
            paciente4.setEmail("ana.torres@gmail.com");
            paciente4.setNombre("Ana Torres");
            paciente4.setTelefono("543-2109");
            paciente4.setSexo(false);
            paciente4.setDireccion("Calle La Paz 321");
            paciente4.setEdad("36");
            paciente4.setPeso("70");
            paciente4.setAltura("1.70");
            paciente4.setPassword(passwordEncoder.encode("12345678"));
            paciente4.setRole("PACIENTE");

            Usuario paciente5 = new Usuario();
            paciente5.setEmail("luis.morales@gmail.com");
            paciente5.setNombre("Luis Morales");
            paciente5.setTelefono("678-9012");
            paciente5.setSexo(true);
            paciente5.setDireccion("Av. Libertador 654");
            paciente5.setEdad("40");
            paciente5.setPeso("85");
            paciente5.setAltura("1.75");
            paciente5.setPassword(passwordEncoder.encode("12345678"));
            paciente5.setRole("PACIENTE");

            Usuario paciente6 = new Usuario();
            paciente6.setEmail("sofia.castillo@gmail.com");
            paciente6.setNombre("Sofía Castillo");
            paciente6.setTelefono("890-1234");
            paciente6.setSexo(false);
            paciente6.setDireccion("Calle Beni 789");
            paciente6.setEdad("29");
            paciente6.setPeso("60");
            paciente6.setAltura("1.62");
            paciente6.setPassword(passwordEncoder.encode("12345678"));
            paciente6.setRole("PACIENTE");

            Usuario paciente7 = new Usuario();
            paciente7.setEmail("jorge.silva@gmail.com");
            paciente7.setNombre("Jorge Silva");
            paciente7.setTelefono("432-1098");
            paciente7.setSexo(true);
            paciente7.setDireccion("Av. Oruro 456");
            paciente7.setEdad("38");
            paciente7.setPeso("78");
            paciente7.setAltura("1.77");
            paciente7.setPassword(passwordEncoder.encode("12345678"));
            paciente7.setRole("PACIENTE");

            Usuario paciente8 = new Usuario();
            paciente8.setEmail("paula.medina@gmail.com");
            paciente8.setNombre("Paula Medina");
            paciente8.setTelefono("321-6540");
            paciente8.setSexo(false);
            paciente8.setDireccion("Calle Gran Chaco 321");
            paciente8.setEdad("30");
            paciente8.setPeso("67");
            paciente8.setAltura("1.68");
            paciente8.setPassword(passwordEncoder.encode("12345678"));
            paciente8.setRole("PACIENTE");


            ourUserRepo.save(paciente1);
            ourUserRepo.save(paciente2);
            ourUserRepo.save(paciente3);
            ourUserRepo.save(paciente4);
            ourUserRepo.save(paciente5);
            ourUserRepo.save(paciente6);
            ourUserRepo.save(paciente7);
            ourUserRepo.save(paciente8);
        }

        // HORARIO ATENCION
        if (horarioAtencionRepository.count() == 0) {
            //  8:00 A.M.
            HorarioAtencion horarioAtencion1 = new HorarioAtencion();
            horarioAtencion1.setHoraInicio("08:00:00");
            horarioAtencion1.setHoraFin("08:15:00");
            horarioAtencion1.setHora("08");

            HorarioAtencion horarioAtencion2 = new HorarioAtencion();
            horarioAtencion2.setHoraInicio("08:15:00");
            horarioAtencion2.setHoraFin("08:30:00");
            horarioAtencion2.setHora("08");

            HorarioAtencion horarioAtencion3 = new HorarioAtencion();
            horarioAtencion3.setHoraInicio("08:30:00");
            horarioAtencion3.setHoraFin("08:45:00");
            horarioAtencion3.setHora("08");

            HorarioAtencion horarioAtencion4 = new HorarioAtencion();
            horarioAtencion4.setHoraInicio("08:45:00");
            horarioAtencion4.setHoraFin("09:00:00");
            horarioAtencion4.setHora("08");

            //  9:00 A.M.
            HorarioAtencion horarioAtencion5 = new HorarioAtencion();
            horarioAtencion5.setHoraInicio("09:00:00");
            horarioAtencion5.setHoraFin("09:15:00");
            horarioAtencion5.setHora("09");

            HorarioAtencion horarioAtencion6 = new HorarioAtencion();
            horarioAtencion6.setHoraInicio("09:15:00");
            horarioAtencion6.setHoraFin("09:30:00");
            horarioAtencion6.setHora("09");

            HorarioAtencion horarioAtencion7 = new HorarioAtencion();
            horarioAtencion7.setHoraInicio("09:30:00");
            horarioAtencion7.setHoraFin("09:45:00");
            horarioAtencion7.setHora("09");

            HorarioAtencion horarioAtencion8 = new HorarioAtencion();
            horarioAtencion8.setHoraInicio("09:45:00");
            horarioAtencion8.setHoraFin("10:00:00");
            horarioAtencion8.setHora("09");

            //  10:00 A.M.
            HorarioAtencion horarioAtencion9 = new HorarioAtencion();
            horarioAtencion9.setHoraInicio("10:00:00");
            horarioAtencion9.setHoraFin("10:15:00");
            horarioAtencion9.setHora("10");

            HorarioAtencion horarioAtencion10 = new HorarioAtencion();
            horarioAtencion10.setHoraInicio("10:15:00");
            horarioAtencion10.setHoraFin("10:30:00");
            horarioAtencion10.setHora("10");

            HorarioAtencion horarioAtencion11 = new HorarioAtencion();
            horarioAtencion11.setHoraInicio("10:30:00");
            horarioAtencion11.setHoraFin("10:45:00");
            horarioAtencion11.setHora("10");

            HorarioAtencion horarioAtencion12 = new HorarioAtencion();
            horarioAtencion12.setHoraInicio("10:45:00");
            horarioAtencion12.setHoraFin("11:00:00");
            horarioAtencion12.setHora("10");


            //  11:00 A.M.
            HorarioAtencion horarioAtencion13 = new HorarioAtencion();
            horarioAtencion13.setHoraInicio("11:00:00");
            horarioAtencion13.setHoraFin("11:15:00");
            horarioAtencion13.setHora("11");

            HorarioAtencion horarioAtencion14 = new HorarioAtencion();
            horarioAtencion14.setHoraInicio("11:15:00");
            horarioAtencion14.setHoraFin("11:30:00");
            horarioAtencion14.setHora("11");

            HorarioAtencion horarioAtencion15 = new HorarioAtencion();
            horarioAtencion15.setHoraInicio("11:30:00");
            horarioAtencion15.setHoraFin("11:45:00");
            horarioAtencion15.setHora("11");

            HorarioAtencion horarioAtencion16 = new HorarioAtencion();
            horarioAtencion16.setHoraInicio("11:45:00");
            horarioAtencion16.setHoraFin("12:00:00");
            horarioAtencion16.setHora("11");


            //  13:00 A.M.
            HorarioAtencion horarioAtencion17 = new HorarioAtencion();
            horarioAtencion17.setHoraInicio("13:00:00");
            horarioAtencion17.setHoraFin("13:15:00");
            horarioAtencion17.setHora("13");

            HorarioAtencion horarioAtencion18 = new HorarioAtencion();
            horarioAtencion18.setHoraInicio("13:15:00");
            horarioAtencion18.setHoraFin("13:30:00");
            horarioAtencion18.setHora("13");

            HorarioAtencion horarioAtencion19 = new HorarioAtencion();
            horarioAtencion19.setHoraInicio("13:30:00");
            horarioAtencion19.setHoraFin("13:45:00");
            horarioAtencion19.setHora("13");

            HorarioAtencion horarioAtencion20 = new HorarioAtencion();
            horarioAtencion20.setHoraInicio("13:45:00");
            horarioAtencion20.setHoraFin("14:00:00");
            horarioAtencion20.setHora("13");


            //  14:00 A.M.
            HorarioAtencion horarioAtencion21 = new HorarioAtencion();
            horarioAtencion21.setHoraInicio("14:00:00");
            horarioAtencion21.setHoraFin("14:15:00");
            horarioAtencion21.setHora("14");

            HorarioAtencion horarioAtencion22 = new HorarioAtencion();
            horarioAtencion22.setHoraInicio("14:15:00");
            horarioAtencion22.setHoraFin("14:30:00");
            horarioAtencion22.setHora("14");

            HorarioAtencion horarioAtencion23 = new HorarioAtencion();
            horarioAtencion23.setHoraInicio("14:30:00");
            horarioAtencion23.setHoraFin("14:45:00");
            horarioAtencion23.setHora("14");

            HorarioAtencion horarioAtencion24 = new HorarioAtencion();
            horarioAtencion24.setHoraInicio("14:45:00");
            horarioAtencion24.setHoraFin("15:00:00");
            horarioAtencion24.setHora("14");


            //  15:00 A.M.
            HorarioAtencion horarioAtencion25 = new HorarioAtencion();
            horarioAtencion25.setHoraInicio("15:00:00");
            horarioAtencion25.setHoraFin("15:15:00");
            horarioAtencion25.setHora("15");

            HorarioAtencion horarioAtencion26 = new HorarioAtencion();
            horarioAtencion26.setHoraInicio("15:15:00");
            horarioAtencion26.setHoraFin("15:30:00");
            horarioAtencion26.setHora("15");

            HorarioAtencion horarioAtencion27 = new HorarioAtencion();
            horarioAtencion27.setHoraInicio("15:30:00");
            horarioAtencion27.setHoraFin("15:45:00");
            horarioAtencion27.setHora("15");

            HorarioAtencion horarioAtencion28 = new HorarioAtencion();
            horarioAtencion28.setHoraInicio("15:45:00");
            horarioAtencion28.setHoraFin("16:00:00");
            horarioAtencion28.setHora("15");

            //  16:00 A.M.
            HorarioAtencion horarioAtencion29 = new HorarioAtencion();
            horarioAtencion29.setHoraInicio("16:00:00");
            horarioAtencion29.setHoraFin("16:15:00");
            horarioAtencion29.setHora("16");

            HorarioAtencion horarioAtencion30 = new HorarioAtencion();
            horarioAtencion30.setHoraInicio("16:15:00");
            horarioAtencion30.setHoraFin("16:30:00");
            horarioAtencion30.setHora("16");

            HorarioAtencion horarioAtencion31 = new HorarioAtencion();
            horarioAtencion31.setHoraInicio("16:30:00");
            horarioAtencion31.setHoraFin("16:45:00");
            horarioAtencion31.setHora("16");

            HorarioAtencion horarioAtencion32 = new HorarioAtencion();
            horarioAtencion32.setHoraInicio("16:45:00");
            horarioAtencion32.setHoraFin("17:00:00");
            horarioAtencion32.setHora("16");


            horarioAtencionRepository.save(horarioAtencion1);
            horarioAtencionRepository.save(horarioAtencion2);
            horarioAtencionRepository.save(horarioAtencion3);
            horarioAtencionRepository.save(horarioAtencion4);

            horarioAtencionRepository.save(horarioAtencion5);
            horarioAtencionRepository.save(horarioAtencion6);
            horarioAtencionRepository.save(horarioAtencion7);
            horarioAtencionRepository.save(horarioAtencion8);

            horarioAtencionRepository.save(horarioAtencion9);
            horarioAtencionRepository.save(horarioAtencion10);
            horarioAtencionRepository.save(horarioAtencion11);
            horarioAtencionRepository.save(horarioAtencion12);

            horarioAtencionRepository.save(horarioAtencion13);
            horarioAtencionRepository.save(horarioAtencion14);
            horarioAtencionRepository.save(horarioAtencion15);
            horarioAtencionRepository.save(horarioAtencion16);

            horarioAtencionRepository.save(horarioAtencion17);
            horarioAtencionRepository.save(horarioAtencion18);
            horarioAtencionRepository.save(horarioAtencion19);
            horarioAtencionRepository.save(horarioAtencion20);

            horarioAtencionRepository.save(horarioAtencion21);
            horarioAtencionRepository.save(horarioAtencion22);
            horarioAtencionRepository.save(horarioAtencion23);
            horarioAtencionRepository.save(horarioAtencion24);

            horarioAtencionRepository.save(horarioAtencion25);
            horarioAtencionRepository.save(horarioAtencion26);
            horarioAtencionRepository.save(horarioAtencion27);
            horarioAtencionRepository.save(horarioAtencion28);

            horarioAtencionRepository.save(horarioAtencion29);
            horarioAtencionRepository.save(horarioAtencion30);
            horarioAtencionRepository.save(horarioAtencion31);
            horarioAtencionRepository.save(horarioAtencion32);

        }

        // Especialidades
        // (Medicina Interna, Pediatría, Cardiología, Dermatología, Neumología, Psiquiatría, Ortopedia, Oncología)
        /*if (especialidadRepository.count() == 0) { //medicos con id de 3 a 8


            Especialidad Especialidad1 = new Especialidad();

            Especialidad1.setNombre("Pediatría");

            Usuario medico1 = ourUserRepo.findById(3)
                    .orElseThrow(() -> new RuntimeException("Medico not found with id 3"));

            Especialidad1.setMedico(medico1);
            //------

            Especialidad Especialidad2 = new Especialidad();

            Especialidad2.setNombre("Cardiología");

            Usuario medico2 = ourUserRepo.findById(3)
                    .orElseThrow(() -> new RuntimeException("Medico not found with id 3"));

            //Usuario medico4 = ourUserRepo.findById(5)
            //        .orElseThrow(() -> new RuntimeException("Medico not found with id 5"));


            Especialidad2.setMedico(medico2);
            //Especialidad2.setMedico(medico4);
            //------

            Especialidad Especialidad3 = new Especialidad();

            Especialidad3.setNombre("Dermatología");

            Usuario medico3 = ourUserRepo.findById(4)
                    .orElseThrow(() -> new RuntimeException("Medico not found with id 4"));

            Especialidad3.setMedico(medico3);
            //------

            Especialidad Especialidad4 = new Especialidad();

            Especialidad4.setNombre("Dermatología");

            Usuario medico4 = ourUserRepo.findById(5)
                    .orElseThrow(() -> new RuntimeException("Medico not found with id 5"));

            Especialidad4.setMedico(medico4);

            //Especialidad Especialidad5 = new Especialidad();

            //Especialidad5.setNombre("Oncología");

            especialidadRepository.save(Especialidad1);
            especialidadRepository.save(Especialidad2);
            especialidadRepository.save(Especialidad3);
            especialidadRepository.save(Especialidad4);
            //especialidadRepository.save(Especialidad5);

        }
        */


        // Modulos
//        if (modulosRepository.count() == 0) {
//            Modulos modulos1 = new Modulos();
//            modulos1.setNumero(256);
//            modulos1.setDescripcion("Modulo de la facultad de ciencias empresariales");
//            modulos1.setUbicacion("-17.818444166536366,-63.099470599823015");
//
//            Modulos modulos2 = new Modulos();
//            modulos2.setNumero(213);
//            modulos2.setDescripcion("Modulo de la facultad de computación");
//            modulos2.setUbicacion("-17.818444166536366,-63.099470599823015");
//
//            Facultades facultad1 = facultadesRepository.findById(1)
//                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 1"));
//
//            Facultades facultad2 = facultadesRepository.findById(2)
//                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 2"));
//
//            modulos1.setFacultad(facultad1);
//            modulos2.setFacultad(facultad2);
//
//            modulosRepository.save(modulos1);
//            modulosRepository.save(modulos2);
//        }

        // Aulas
//        if (aulasRepository.count() == 0) {
//            Aulas aulas1 = new Aulas();
//            aulas1.setCapacidad(65);
//            aulas1.setNumero(35);
//            aulas1.setPiso(3);
//            aulas1.setDescripcion("Aula para avanzar teoria");
//
//            Modulos modulo1 = modulosRepository.findById(1)
//                    .orElseThrow(() -> new RuntimeException("Modulo not found with id 1"));
//
//            aulas1.setModulos(modulo1);
//
//
//
//            aulasRepository.save(aulas1);
//
//        }

        // carreras
//        if (carrerasRepository.count() == 0) {
//            Carreras carreras1 = new Carreras();
//            carreras1.setCodigo("ING.SIS");
//            carreras1.setNombre("Ingenieria en sistemas");
//
//            carrerasRepository.save(carreras1);
//
//        }

        // Materias
//        if (materiasRepository.count() == 0) {
//            Materias materias1 = new Materias();
//            materias1.setSigla("SI2");
//            materias1.setNombre("Sistemas de información 2");
//
//            materiasRepository.save(materias1);
//
//        }

        // Permisos
        if (permisosRepository.count() == 0) {
            createPermisos();
        }

        // Roles
        if (rolesRepository.count() == 0) {
            // Obtener todos los permisos ya creados
            List<Permiso> permisos = permisosRepository.findAll();

            // Crear el rol y asignar todos los permisos obtenidos
            Rol rolAdmin = new Rol();
            rolAdmin.setNombre("ADMIN");
            rolAdmin.setPermissions(new ArrayList<>(permisos));

            // Guardar el rol en el repositorio
            rolesRepository.save(rolAdmin);

            // Filtrar los permisos para el rol "PACIENTE"
            List<Permiso> permisosUsuarios = new ArrayList<>();
            for (Permiso permiso : permisosRepository.findAll()) {
                if (permiso.getNombre().startsWith("Ver") &&
                        !permiso.getNombre().equals("Sacar Ficha") &&
                !permiso.getNombre().equals("Ver Medico y Especialidad")&&
                        !permiso.getNombre().equals("Sacar Ficha")) {
                    permisosUsuarios.add(permiso);
                }
            }

            // Crear el rol "USERS" y asignar los permisos filtrados
            Rol rolPaciente = new Rol();
            rolPaciente.setNombre("PACIENTE");
            rolPaciente.setPermissions(permisosUsuarios);

            // Guardar el rol "PACIENTE" en el repositorio
            rolesRepository.save(rolPaciente);

            // Filtrar los permisos para el rol "MEDICO"
            List<Permiso> permisosMedico = new ArrayList<>();
            for (Permiso permiso : permisosRepository.findAll()) {
                if (permiso.getNombre().startsWith("Listar") &&
                        !permiso.getNombre().equals("Listar Medico")
                        &&
                        !permiso.getNombre().equals("Ver Ficha")) {
                    permisosUsuarios.add(permiso);
                }
            }

            // Crear el rol "USERS" y asignar los permisos filtrados
            Rol rolMedico = new Rol();
            rolMedico.setNombre("MEDICO");
            rolMedico.setPermissions(permisosMedico);

            // Guardar el rol "PACIENTE" en el repositorio
            rolesRepository.save(rolMedico);

        }

    }

    private void createPermisos() {
        permisosRepository.save(createPermiso("Listar Usuario"));
        permisosRepository.save(createPermiso("Crear Usuario"));
        permisosRepository.save(createPermiso("Editar Usuario"));
        permisosRepository.save(createPermiso("Eliminar Usuario"));

        permisosRepository.save(createPermiso("Listar Especialidad"));
        permisosRepository.save(createPermiso("Crear Especialidad"));
        permisosRepository.save(createPermiso("Editar Especialidad"));
        permisosRepository.save(createPermiso("Eliminar Especialidad"));

        permisosRepository.save(createPermiso("Listar Medico"));
        permisosRepository.save(createPermiso("Crear Medico"));
        permisosRepository.save(createPermiso("Editar Medico"));
        permisosRepository.save(createPermiso("Eliminar Medico"));

        permisosRepository.save(createPermiso("Listar Horario"));
        permisosRepository.save(createPermiso("Crear Horario"));
        permisosRepository.save(createPermiso("Editar Horario"));
        permisosRepository.save(createPermiso("Eliminar Horario"));

        permisosRepository.save(createPermiso("Listar Pacientes"));
        permisosRepository.save(createPermiso("Crear Pacientes"));
        permisosRepository.save(createPermiso("Editar Pacientes"));
        permisosRepository.save(createPermiso("Eliminar Pacientes"));

        permisosRepository.save(createPermiso("Ver Medico y Especialidad"));
        permisosRepository.save(createPermiso("Sacar Ficha"));
        permisosRepository.save(createPermiso("Ver Ficha"));
        permisosRepository.save(createPermiso("Ver Historial"));






//        permisosRepository.save(createPermiso("Listar Carreras"));
//        permisosRepository.save(createPermiso("Editar Carreras"));
//        permisosRepository.save(createPermiso("Eliminar Carreras"));
//        permisosRepository.save(createPermiso("Crear Carreras"));
//
//        permisosRepository.save(createPermiso("Listar Facultades"));
//        permisosRepository.save(createPermiso("Editar Facultades"));
//        permisosRepository.save(createPermiso("Eliminar Facultades"));
//        permisosRepository.save(createPermiso("Crear Facultades"));
//
//        permisosRepository.save(createPermiso("Listar Modulos"));
//        permisosRepository.save(createPermiso("Editar Modulos"));
//        permisosRepository.save(createPermiso("Eliminar Modulos"));
//        permisosRepository.save(createPermiso("Crear Modulos"));
//
//        permisosRepository.save(createPermiso("Listar Aulas"));
//        permisosRepository.save(createPermiso("Editar Aulas"));
//        permisosRepository.save(createPermiso("Eliminar Aulas"));
//        permisosRepository.save(createPermiso("Crear Aulas"));
    }

    private Permiso createPermiso(String nombre) {
        Permiso permiso = new Permiso();
        permiso.setNombre(nombre);
        return permiso;
    }

}
