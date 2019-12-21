(ns darmok-core-logic.demo
  (:require
   [clojure.core.logic :as l]
   [darmok-core-logic.core :refer :all]))

;; Demonstrating success with the cooperation allegory.
(l/run* [tam hum eng]
        (cooperation tam hum eng))

;; Demonstrating success with the cooperation allegory with one element given.
(l/run* [hum eng]
        (cooperation "Darmok and Jalad at Tanagra." hum eng))

;; Demonstrating failure with the cooperation allegory.
(l/run* [tam hum eng]
        (cooperation tam hum "challenge"))

;; Demonstrating all possible answers for allegories.
(l/run* [tam hum eng]
        (allegory tam hum eng))

;; Demonstrating getting two possible answers for allegories.
(l/run 2 [tam hum eng]
       (allegory tam hum eng))

;; Demonstrating all possible answers for a shortened representation of allegories.
(l/run* [x]
        (allegory-short x))

;; Demonstrating five possible answers for a shortened representation of allegories.
(l/run 5 [x]
       (allegory-short x))

;; Demonstrating any possible phrase for failure.
(l/run* [x]
        (failure-any x))

;; Demonstrating two possible answers for 5 element stories that start with a failure and end with a successful first contact with phrases in any possible language.
(l/run 2 [x1 x2 x3 x4 x5]
       (five-element-story x1 x2 x3 x4 x5))

;; Demonstrating a generator for distinct n element stories that start with a failure and end with a successful first contact with phrases in any possible language.
(n-element-story 4 6)
