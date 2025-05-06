package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.BloodTestResultDTO;
import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.enums.PetGender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResultsProcessingService {

    public Map<String, String> processDogResults(PetDTO pet, BloodTestResultDTO testResult) {
        Map<String, String> results = new HashMap<>();
        if (pet.getGender().equals(PetGender.MALE)) {
            if (pet.getAge() <= 7 && pet.getAge() >= 1) {
                results.put("erythrocytes", (testResult.getErythrocytes() < 6.57 && testResult.getErythrocytes() > 5.26) ? "OK" : (testResult.getErythrocytes() < 5.26 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 16.3 && testResult.getHemoglobin() > 12.7) ? "OK" : (testResult.getHemoglobin() < 12.7 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 19.5 && testResult.getLeukocytes() > 8.3) ? "OK" : (testResult.getLeukocytes() < 8.3 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 73 && testResult.getNeutrophils() > 65) ? "OK" : (testResult.getNeutrophils() < 65 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 26 && testResult.getLymphocytes() > 9) ? "OK" : (testResult.getLymphocytes() < 9 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 10 && testResult.getMonocytes() > 2) ? "OK" : (testResult.getMonocytes() < 2 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 8 && testResult.getEosinophils() > 1) ? "OK" : (testResult.getEosinophils() < 1 ? "reduced" : "increased"));
            } else if (pet.getAge() < 1) {
                results.put("erythrocytes", (testResult.getErythrocytes() < 8.52 && testResult.getErythrocytes() > 2.99) ? "OK" : (testResult.getErythrocytes() < 2.99 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 16.5 && testResult.getHemoglobin() > 6.9) ? "OK" : (testResult.getHemoglobin() < 6.9 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 27.7 && testResult.getLeukocytes() > 9.9) ? "OK" : (testResult.getLeukocytes() < 9.9 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 73 && testResult.getNeutrophils() > 63) ? "OK" : (testResult.getNeutrophils() < 63 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 30 && testResult.getErythrocytes() > 18) ? "OK" : (testResult.getLymphocytes() < 18 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 10 && testResult.getMonocytes() > 1) ? "OK" : (testResult.getMonocytes() < 1 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 11 && testResult.getEosinophils() > 2) ? "OK" : (testResult.getEosinophils() < 2 ? "reduced" : "increased"));

            } else {
                results.put("erythrocytes", (testResult.getErythrocytes() < 7.76 && testResult.getErythrocytes() > 3.33) ? "OK" : (testResult.getErythrocytes() < 3.33 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 21.2 && testResult.getHemoglobin() > 14.7) ? "OK" : (testResult.getHemoglobin() < 14.7 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 35.3 && testResult.getLeukocytes() > 7.9) ? "OK" : (testResult.getLeukocytes() < 7.9 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 80 && testResult.getNeutrophils() > 55) ? "OK" : (testResult.getNeutrophils() < 55 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 40 && testResult.getLymphocytes() > 15) ? "OK" : (testResult.getLymphocytes() < 15 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 4 && testResult.getMonocytes() > 0) ? "OK" : (testResult.getMonocytes() < 0 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 11 && testResult.getEosinophils() > 1) ? "OK" : (testResult.getEosinophils() < 1 ? "reduced" : "increased"));
            }
        } else {
            if (pet.getAge() >= 1 && pet.getAge() <= 7) {
                results.put("erythrocytes", (testResult.getErythrocytes() < 8.6 && testResult.getErythrocytes() > 5.13) ? "OK" : (testResult.getErythrocytes() < 5.13 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 17.9 && testResult.getHemoglobin() > 11.5) ? "OK" : (testResult.getHemoglobin() < 11.5 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 17.5 && testResult.getLeukocytes() > 7.5) ? "OK" : (testResult.getLeukocytes() < 7.5 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 76 && testResult.getNeutrophils() > 58) ? "OK" : (testResult.getNeutrophils() < 58 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 29 && testResult.getLymphocytes() > 11) ? "OK" : (testResult.getLymphocytes() < 11 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 10 && testResult.getMonocytes() > 0) ? "OK" : (testResult.getMonocytes() < 0 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 10 && testResult.getEosinophils() > 1) ? "OK" : (testResult.getEosinophils() < 1 ? "reduced" : "increased"));
            } else if (pet.getAge() < 1) {
                results.put("erythrocytes", (testResult.getErythrocytes() < 8.42 && testResult.getErythrocytes() > 2.76) ? "OK" : (testResult.getErythrocytes() < 2.76 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 18.9 && testResult.getHemoglobin() > 6.4) ? "OK" : (testResult.getHemoglobin() < 6.4 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 26.8 && testResult.getLeukocytes() > 8.8) ? "OK" : (testResult.getLeukocytes() < 8.8 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 74 && testResult.getNeutrophils() > 64) ? "OK" : (testResult.getNeutrophils() < 64 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 28 && testResult.getLymphocytes() > 13) ? "OK" : (testResult.getLymphocytes() < 13 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 10 && testResult.getMonocytes() > 1) ? "OK" : (testResult.getMonocytes() < 1 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 9 && testResult.getEosinophils() > 1) ? "OK" : (testResult.getEosinophils() < 1 ? "reduced" : "increased"));
            } else {
                results.put("erythrocytes", (testResult.getErythrocytes() < 9.19 && testResult.getErythrocytes() > 3.34) ? "OK" : (testResult.getErythrocytes() < 3.34 ? "reduced" : "increased"));
                results.put("hemoglobin", (testResult.getHemoglobin() < 22.5 && testResult.getHemoglobin() > 11) ? "OK" : (testResult.getHemoglobin() < 11 ? "reduced" : "increased"));
                results.put("leukocytes", (testResult.getLeukocytes() < 34 && testResult.getLeukocytes() > 5.2) ? "OK" : (testResult.getLeukocytes() < 5.2 ? "reduced" : "increased"));
                results.put("neutrophils", (testResult.getNeutrophils() < 80 && testResult.getNeutrophils() > 40) ? "OK" : (testResult.getNeutrophils() < 40 ? "reduced" : "increased"));
                results.put("lymphocytes", (testResult.getLymphocytes() < 45 && testResult.getLymphocytes() > 13) ? "OK" : (testResult.getLymphocytes() < 13 ? "reduced" : "increased"));
                results.put("monocytes", (testResult.getMonocytes() < 4 && testResult.getMonocytes() > 0) ? "OK" : (testResult.getMonocytes() < 0 ? "reduced" : "increased"));
                results.put("eosinophils", (testResult.getEosinophils() < 19 && testResult.getEosinophils() > 0) ? "OK" : (testResult.getEosinophils() < 0 ? "reduced" : "increased"));
            }
        }
        return results;
    }

    public Map<String, String> processCatResults(BloodTestResultDTO testResult) {
        Map<String, String> results = new HashMap<>();
        results.put("erythrocytes", (testResult.getErythrocytes() < 10.7 && testResult.getErythrocytes() > 5.8) ? "OK" : (testResult.getErythrocytes() < 5.8 ? "reduced" : "increased"));
        results.put("hemoglobin", (testResult.getHemoglobin() < 15 && testResult.getHemoglobin() > 9) ? "OK" : (testResult.getHemoglobin() < 9 ? "reduced" : "increased"));
        results.put("leukocytes", (testResult.getLeukocytes() < 19 && testResult.getLeukocytes() > 10) ? "OK" : (testResult.getLeukocytes() < 10 ? "reduced" : "increased"));
        results.put("neutrophils", (testResult.getNeutrophils() < 75 && testResult.getNeutrophils() > 35) ? "OK" : (testResult.getNeutrophils() < 35 ? "reduced" : "increased"));
        results.put("lymphocytes", (testResult.getLymphocytes() < 55 && testResult.getLymphocytes() > 20) ? "OK" : (testResult.getLymphocytes() < 20 ? "reduced" : "increased"));
        results.put("monocytes", (testResult.getMonocytes() < 4 && testResult.getMonocytes() > 1) ? "OK" : (testResult.getMonocytes() < 1 ? "reduced" : "increased"));
        results.put("eosinophils", (testResult.getEosinophils() < 4 && testResult.getEosinophils() > 0) ? "OK" : (testResult.getEosinophils() < 0 ? "reduced" : "increased"));
        return results;
    }

    public ArrayList<String> getAdditionalInformation(Map<String, String> results) {
        ArrayList<String> additionalInformation = new ArrayList<>();
        if (results.get("erythrocytes").equals("reduced")) {
            additionalInformation.add("Low red blood cells can be caused by anemia, bleeding (including hidden). " +
                    "Chronic inflammatory processes. " +
                    "Hypervolemia - introduction of a large volume of fluid into the vascular bed.");
        } else if (results.get("erythrocytes").equals("increased")) {
            additionalInformation.add("Elevated red blood cells can be caused by  significant physical exertion," +
                    " dehydration. Diseases of the blood, respiratory organs, heart defects. " +
                    "Poisoning with organophosphorus compounds.");
        }

        if (results.get("hemoglobin").equals("reduced")){
            additionalInformation.add("Lower hemoglobin can be caused by anemias, bleeding, autoimmune diseases, " +
                    "long-term inflammatory process. Violation of the assimilation of iron, vitamin B12. " +
                    "Parasitic infestations.");
        } else if (results.get("hemoglobin").equals("increased")) {
            additionalInformation.add("Elevated hemoglobin may be caused by increased physical activity, " +
                    "insufficient fluid intake. Heart defects, pulmonary fibrosis, " +
                    "tumor diseases, intestinal obstruction.");
        }

        if (results.get("leukocytes").equals("reduced")){
            additionalInformation.add("Low white blood cells may be caused by recent food intake, pregnancy. " +
                    "General inflammatory process, bacterial infections, worm infestations.");
        } else if (results.get("leukocytes").equals("increased")) {
            additionalInformation.add("Elevated white blood cells may be caused by long-term intake of antibiotics," +
                    " radiation therapy and its consequences. Hemorrhages. Some infectious processes," +
                    " immune suppression, blood and bone marrow diseases, liver disease.");
        }

        if (results.get("neutrophils").equals("reduced")){
            additionalInformation.add("Lowered neutrophils may be caused by hemorrhages, " +
                    "diseases of the red bone marrow. Some infections, fungal lesions.");
        } else if (results.get("neutrophils").equals("increased")) {
            additionalInformation.add("Elevated neutrophils may be caused by excessive physical activity, " +
                    "stressful conditions, shock. Acute and chronic inflammation, infectious diseases, tumors.");
        }

        if (results.get("lymphocytes").equals("reduced")){
            additionalInformation.add("Low lymphocytes may be caused by prolonged therapy" +
                    " with glucocorticosteroid hormones, radiation exposure. Autoimmune diseases, tumors.");
        } else if (results.get("lymphocytes").equals("increased")) {
            additionalInformation.add("Elevated lymphocytes may be caused by strong physical exertion, " +
                    "stress, changes in the hormonal background. Anemias, lympholeukosis.");
        }

        if (results.get("monocytes").equals("reduced")){
            additionalInformation.add("Cause of low monocytes may be acute infections, sepsis.");
        } else if (results.get("monocytes").equals("increased")) {
            additionalInformation.add("Cause of elevated monocytes may be chronic infections," +
                    " parasitic diseases. Tumors.");
        }

        if (results.get("eosinophils").equals("reduced")){
            additionalInformation.add("A decreased eosinophil count is not clinically significant.");
        } else if (results.get("eosinophils").equals("increased")) {
            additionalInformation.add("Elevated eosinophils may be caused by allergic diseases, helminthiasis. " +
                    "New neoplasms.");
        }
        return additionalInformation;
    }
}
