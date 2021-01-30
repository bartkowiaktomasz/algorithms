"""
Implementation of Knuth-Morris-Pratt Algorithm
"""


class KMPSearch:
    @staticmethod
    def build_lps(p: str):
        lps_arr = [0 for _ in range(len(p))]
        i = 1
        len_lps = 0
        while i < len(p):
            if p[i] == p[len_lps]:
                len_lps += 1
                lps_arr[i] = len_lps
                i += 1
            else:
                """
                Trickiest part
                Consider "AAACAAAA" and we are at idx == 7 (last `A`):
                - `A` does not match `C` (character at current `len_lps`)
                - We should NOT reset len_lps to 0 and assign lps_arr[7] = 0
                - Instead, go to the letter before where we failed (here: A, idx == 2)
                and check if we match it. If we do, our lps is equal to its 
                lps (here: lps_arr[2], i.e. 2) + 1
                
                # lps("AAACAAAA") = [0, 1, 2, 0, 1, 2, 3, 3]
                """
                if len_lps != 0:
                    len_lps = lps_arr[len_lps - 1]
                else:
                    lps_arr[i] = 0
                    i += 1
        return lps_arr

    @staticmethod
    def find(s: str, p: str):
        lps = KMPSearch.build_lps(p)
        i = 0
        j = 0
        while i < len(s):
            if j == len(p):
                return i - len(p)
            if s[i] == p[j]:
                i += 1
                j += 1
            else:
                if j == 0:
                    i += 1
                else:
                    j = lps[j - 1]
        if j == len(p):
            return i - len(p)
        return -1


if __name__ == "__main__":
    print(
        KMPSearch.find("aaaaa", "bba")
    )


