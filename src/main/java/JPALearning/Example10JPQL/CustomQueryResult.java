
package JPALearning.Example10JPQL;

class CustomQueryResult {
    private String numeStudent;
    private long nr;

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public CustomQueryResult(String numeStudent, long nr) {
        this.numeStudent = numeStudent;
        this.nr = nr;
        }

    @Override
    public String toString() {
        return "CustomQueryResult{" +
                "numeStudent='" + numeStudent + '\'' +
                ", nr=" + nr +
                '}';
    }
}
