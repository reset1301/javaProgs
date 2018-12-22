package hello.dao;

import javax.persistence.*;

@Entity
@Table(name = "userdoc", schema = "public", catalog = "org")
public class UserDoc {
    private long id;
    private String docNumber;
    private Long docDate;
    private Docs docs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "doc_number")
    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    @Column(name = "doc_date")
    public Long getDocDate() {
        return docDate;
    }

    public void setDocDate(Long docDate) {
        this.docDate = docDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_id", referencedColumnName = "id", nullable = false)
    public Docs getDocs() {
        return docs;
    }

    public void setDocs(Docs docs) {
        this.docs = docs;
    }
}
