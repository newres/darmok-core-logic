(ns darmok-core-logic.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.logic :as l]
            [darmok-core-logic.core :refer :all]))

;; Unit Tests

(deftest failiure-test
  (testing "The failure allegory."
    (is (= '(["Shaka, when the walls fell."
              "Gilgamesh, his plant eaten by a snake."
              "failure"])
           (l/run* [tam hum eng]
                   (failure tam hum eng))))))

(deftest common-enemy-test
  (testing "The common enemy allegory."
    (is (= '(["Beast at Tanagra." "Bull of Heaven." "common-enemy"])
           (l/run* [tam hum eng]
                   (common-enemy tam hum eng))))))

(deftest cooperation-test
  (testing "The cooperation allegory."
    (is (= '(["Darmok and Jalad at Tanagra."
              "Gilgamesh and Ekidu at Uruk."
              "cooperation"])           (l/run* [tam hum eng]
                                                (cooperation tam hum eng))))))

(deftest successful-cooperation-test
  (testing "The successful cooperation allegory."
    (is (= '(["Darmok and Jalad at Tanagra."
              "Gilgamesh and Ekidu at Uruk."
              "cooperation"])           (l/run* [tam hum eng]
                                                (successful-cooperation tam hum eng))))))

(deftest successful-cooperation-test
  (testing "The successful cooperation allegory."
    (is (= '(["Picard and Dathon at El-Adrel."
              "Picard and Dathon at El-Adrel."
              "successful-first-contact"])           (l/run* [tam hum eng]
                                                             (successful-first-contact tam hum eng))))))

(deftest allegory-test
  (testing "The total number of allegories."
    (is (= 5           (count (l/run* [tam hum eng]
                                      (allegory tam hum eng)))))))

