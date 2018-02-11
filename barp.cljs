(def family [
                "Homer Simpson"
                "Marge Simpson"
                "Bart Simpson"
                "Lisa Simpson"
                "Maggie Simpson"])

(def abc "abcdefghijklmnopqrstuvxyz")

(defn substitute [input i n]
    (str 
        (subs input 0 i)
        n
        (subs input (inc i))))

(defn mutate [input]
    (let [mutated
            (substitute
                input
                (rand-int (count input))
                (rand-nth abc))]
        (if (zero? (count (filter (partial = " ") mutated)))
            (recur input)
            mutated)))

(defn mutations [name]
    (take 10 (iterate mutate name)))

(println (map mutations family))

