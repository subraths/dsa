package main

import "fmt"

func main() {
	str := "AABABBA"
	res := characterReplacement(str, 1)
	fmt.Println(res)
}

func characterReplacement(s string, k int) int {
	charMap := make(map[rune]int)
	i := 0
	res := 0
	mostFreq := 0
	for j, char := range s {
		v, ok := charMap[char]
		if !ok {
			charMap[char] = 1
		} else {
			charMap[char] = v + 1
		}
		v, ok = charMap[char]
		mostFreq = max(mostFreq, v)

		// check if a window is valid
		if ((j - i + 1) - mostFreq) > k {
			v, _ := charMap[rune(s[i])]
			charMap[rune(s[i])] = v - 1
			i++
		}

		res = max(res, j-i+1)

	}
	return res
}
