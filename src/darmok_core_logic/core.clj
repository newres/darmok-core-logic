(ns darmok-core-logic.core
  (:require [clojure.core.logic :as l]))

;; Synopsis of the Themes in Darmok
;; ------
;; Failure (at understanding).
;; A common enemy (that needs to be fought).
;; Cooperation.
;; Successful cooperation.
;; Successful First Contact.


(defn failure [tam hum eng]
  (l/conde [(l/== [tam] ["Shaka, when the walls fell."])
            (l/== [hum] ["Gilgamesh, his plant eaten by a snake."])
            (l/== [eng] ["failure"])]))

(defn common-enemy [tam hum eng]
  (l/conde [(l/== [tam] ["Beast at Tanagra."])
            (l/== [hum] ["Bull of Heaven."])
            (l/== [eng] ["common-enemy"])]))

(defn cooperation [tam hum eng]
  (l/conde [(l/== [tam] ["Darmok and Jalad at Tanagra."])
            (l/== [hum] ["Gilgamesh and Ekidu at Uruk."])
            (l/== [eng] ["cooperation"])]))

(defn successful-cooperation [tam hum eng]
  (l/conde [(l/== [tam] ["Darmok and Jalad on the ocean."])
            (l/== [hum] ["Gilgamesh and Ekidu, after the Bull's defeat."])
            (l/== [eng] ["successful-cooperation"])]))

(defn successful-first-contact [tam hum eng]
  (l/conde [(l/== [tam] ["Picard and Dathon at El-Adrel."])
            (l/== [hum] ["Picard and Dathon at El-Adrel."])
            (l/== [eng] ["successful-first-contact"])]))

(defn allegory [tam hum eng]
  (l/conde [(cooperation tam hum eng)]
           [(common-enemy tam hum eng)]
           [(cooperation tam hum eng)]
           [(successful-cooperation tam hum eng)]
           [(successful-first-contact tam hum eng)]))

(defn allegory-tam [tam]
  (l/fresh [x y]
           (allegory tam x y)))

(defn allegory-hum [hum]
  (l/fresh [x y]
           (allegory x hum y)))

(defn allegory-eng [eng]
  (l/fresh [x y]
           (allegory x y eng)))

(defn allegory-short [x]
  (l/conde [(allegory-tam x)]
           [(allegory-hum x)]
           [(allegory-eng x)]))

(defn failure-any [x]
  (l/fresh [a1 a2 a3]
           (l/conde [(failure x a1 a2)]
                    [(failure a1 x a2)]
                    [(failure a1 a2 x)])))

(defn successful-first-contact-any [x]
  (l/fresh [a1 a2 a3]
           (l/conde [(successful-first-contact x a1 a2)]
                    [(successful-first-contact a1 x a2)]
                    [(successful-first-contact a1 a2 x)])))

(defn five-element-story [x1, x2, x3, x4, x5]
  (l/fresh [a1 a2 a3]
           (l/conde [(failure-any x1)
                     (allegory-short x2)
                     (allegory-short x3)
                     (allegory-short x4)
                     (successful-first-contact-any x5)])))

(defn n-element-story [nr-of-elements stories]
  (let [vars (repeatedly nr-of-elements l/lvar)
        first-var (first vars)
        middle (drop-last (rest vars))
        last-var (last vars)]
    (l/run stories [q]
           (l/conde [(l/== q vars)
                     (l/distincto q)
                     (failure-any first-var)
                     (successful-first-contact-any last-var)
                     (l/everyg allegory-short middle)]))))
